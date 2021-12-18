package com.length.icthack3.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.length.icthack3.domain.model.Animal
import com.length.icthack3.domain.model.User
import com.length.icthack3.domain.repository.AnimalRepository
import kotlinx.coroutines.tasks.await

class AnimalRepositoryImpl(private val db: FirebaseFirestore) : AnimalRepository {

    private val animalList = MutableLiveData<List<Animal>>()

    override suspend fun getAnimalListForUser(user: User): LiveData<List<Animal>> {
        val animalList = db.collection(Animal.TABLE_NAME)
            .get()
            .addOnFailureListener {
                it.printStackTrace()
            }
            .await()
            .toObjects(Animal::class.java)
        return MutableLiveData(animalList)
    }

    override suspend fun deleteAnimal(animal: Animal) {
        db.collection(Animal.TABLE_NAME)
            .document(animal.id)
            .delete()
            .await()
    }

    override suspend fun getAnimal(animalId: String): Animal? {
        return db.collection(Animal.TABLE_NAME)
            .document(animalId)
            .get()
            .await()
            .toObject(Animal::class.java)
    }

    override suspend fun editAnimal(animal: Animal) {
        db.collection(Animal.TABLE_NAME)
            .document(animal.id)
            .set(animal)
            .await()
    }

    override suspend fun addAnimal(animal: Animal) {
        editAnimal(animal)
    }
}