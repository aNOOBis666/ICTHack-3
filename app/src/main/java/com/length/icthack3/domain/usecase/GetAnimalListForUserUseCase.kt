package com.length.icthack3.domain.usecase

import com.length.icthack3.domain.model.User
import com.length.icthack3.domain.repository.AnimalRepository

class GetAnimalListForUserUseCase(private val repository: AnimalRepository) {

    fun getAnimalListForUser(user: User) {
        repository.getAnimalListForUser(user)
    }
}