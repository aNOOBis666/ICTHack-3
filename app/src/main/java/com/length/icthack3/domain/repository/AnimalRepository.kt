package com.length.icthack3.domain.repository

import androidx.lifecycle.LiveData
import com.length.icthack3.domain.model.Animal
import com.length.icthack3.domain.model.User

interface AnimalRepository {

    fun getAnimalListForUser(user: User): LiveData<List<Animal>>

    fun deleteAnimal(animal: Animal)

    fun getAnimal(animal: Animal): Animal

    fun editAnimal(animal: Animal)

    fun addAnimal(animal: Animal)
}