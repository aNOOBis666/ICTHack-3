package com.length.icthack3.domain.repository

import androidx.lifecycle.LiveData
import com.length.icthack3.domain.model.Animal
import com.length.icthack3.domain.model.User

interface AnimalRepository {

    suspend fun getAnimalListForUser(user: User): LiveData<List<Animal>>

    suspend fun deleteAnimal(animal: Animal)

    suspend fun editAnimal(animal: Animal)

    suspend fun addAnimal(animal: Animal)

    suspend fun getAnimal(animalId: String): Animal?
}