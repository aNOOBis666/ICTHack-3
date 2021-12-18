package com.length.icthack3.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.length.icthack3.domain.model.User
import com.length.icthack3.domain.repository.UserRepository
import kotlinx.coroutines.tasks.await

class UserRepositoryImpl(private val db: FirebaseFirestore) : UserRepository {

    private val userList = MutableLiveData<List<User>>()

    private val userListSorted = sortedSetOf<User>({ p0, p1 -> p0.balance.compareTo(p1.balance) })

    override suspend fun getUser(userId: String): User? {
        return db.collection(User.TABLE_NAME)
            .document(userId)
            .get()
            .await()
            .toObject(User::class.java)
    }

    override fun getUserList(): LiveData<List<User>> {
        return userList
    }

    override suspend fun addUser(user: User) {
        db.collection(User.TABLE_NAME)
            .add(user)
            .addOnSuccessListener {
                userListSorted.add(user)
                updateList()
            }
            .await()
    }

    override suspend fun deleteUser(user: User) {
        db.collection(User.TABLE_NAME)
            .document(user.id)
            .delete()
            .addOnSuccessListener {
                userListSorted.remove(user)
                updateList()
            }
            .await()
    }

    override suspend fun editUser(user: User) {
        db.collection(User.TABLE_NAME)
            .document(user.id)
            .set(user)
            .addOnSuccessListener {
                val oldUser = userListSorted.find { it.id == user.id }
                userListSorted.remove(oldUser)
                userListSorted.add(user)
                updateList()
            }
            .await()
    }

    override suspend fun getUserListAsync() {
        val users = db.collection(User.TABLE_NAME)
            .get()
            .addOnFailureListener {
                it.printStackTrace()
            }
            .await()
            .toObjects(User::class.java)
        userListSorted.addAll(users)
        updateList()
    }

    private fun updateList() {
        userList.postValue(userListSorted.toList())
    }
}