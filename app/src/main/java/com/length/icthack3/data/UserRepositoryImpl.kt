package com.length.icthack3.data

import com.google.firebase.firestore.FirebaseFirestore
import com.length.icthack3.domain.model.User
import com.length.icthack3.domain.repository.UserRepository
import kotlinx.coroutines.tasks.await

class UserRepositoryImpl(private val db: FirebaseFirestore) : UserRepository {

    override suspend fun getUser(userId: String): User? {
        return db.collection(User.TABLE_NAME)
            .document(userId)
            .get()
            .await()
            .toObject(User::class.java)
    }

    override suspend fun addUser(user: User) {
        db.collection(User.TABLE_NAME)
            .document(user.id)
            .set(user)
            .await()
    }

    override suspend fun deleteUser(user: User) {
        db.collection(User.TABLE_NAME)
            .document(user.id)
            .delete()
            .await()
    }

    override suspend fun editUser(user: User) {
        addUser(user)
    }
}