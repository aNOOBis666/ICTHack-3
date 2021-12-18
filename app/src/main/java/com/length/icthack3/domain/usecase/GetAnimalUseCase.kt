package com.length.icthack3.domain.usecase

import com.length.icthack3.domain.model.Animal
import com.length.icthack3.domain.repository.AnimalRepository

class GetAnimalUseCase(private val repository: AnimalRepository) {

    fun getAnimal(animal: Animal) {
        repository.getAnimal(animal)
    }
}