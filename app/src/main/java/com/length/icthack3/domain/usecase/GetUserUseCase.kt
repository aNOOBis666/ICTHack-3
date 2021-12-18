package com.length.icthack3.domain.usecase

import com.length.icthack3.domain.repository.UserRepository

class GetUserUseCase(private val repository: UserRepository) {

    suspend fun getUser(userId: String) {
        repository.getUser(userId)
    }
}