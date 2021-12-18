package com.length.icthack3.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.length.icthack3.domain.model.Animal
import com.length.icthack3.domain.model.User
import com.length.icthack3.domain.repository.AnimalRepository

object AnimalRepositoryImpl : AnimalRepository {

    private val animalList = MutableLiveData<List<Animal>>()

    override fun getAnimalListForUser(user: User): LiveData<List<Animal>> {
        val db = Firebase.firestore
        db
    }

    override fun deleteAnimal(animal: Animal) {
        TODO("Not yet implemented")
    }

    override fun getAnimal(animal: Animal): Animal {
        TODO("Not yet implemented")
    }

    override fun editAnimal(animal: Animal) {
        TODO("Not yet implemented")
    }

    override fun addAnimal(animal: Animal) {
        TODO("Not yet implemented")
    }
}