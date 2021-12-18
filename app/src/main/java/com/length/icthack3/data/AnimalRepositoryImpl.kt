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

    private val animalListSorted = sortedSetOf<Animal>({ p0, p1 -> p0.type.compareTo(p1.type) })

    override suspend fun getAnimalListForUser(user: User): LiveData<List<Animal>> {
        val animals = db.collection(Animal.TABLE_NAME)
            .get()
            .addOnFailureListener {
                it.printStackTrace()
            }
            .await()
            .toObjects(Animal::class.java)
        animalListSorted.addAll(animals)
        updateList()
        return animalList
    }

    override suspend fun deleteAnimal(animal: Animal) {
        db.collection(Animal.TABLE_NAME)
            .document(animal.id)
            .delete()
            .addOnSuccessListener {
                animalListSorted.remove(animal)
                updateList()
            }
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
            .addOnSuccessListener {
                val oldAnimal = animalListSorted.find { it.id == animal.id }
                animalListSorted.remove(oldAnimal)
                animalListSorted.add(animal)
                updateList()
            }
            .await()
    }

    override suspend fun addAnimal(animal: Animal) {
        db.collection(Animal.TABLE_NAME)
            .add(animal)
            .addOnSuccessListener {
                animalListSorted.add(animal)
                updateList()
            }
            .await()
    }

    private fun updateList() {
        animalList.value = animalListSorted.toList()
    }
}