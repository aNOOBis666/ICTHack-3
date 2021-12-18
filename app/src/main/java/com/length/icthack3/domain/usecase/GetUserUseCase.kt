package com.length.icthack3.domain.usecase

import com.length.icthack3.domain.model.User
import com.length.icthack3.domain.repository.UserRepository

class GetUserUseCase(private val repository: UserRepository) {

    fun getUser(user: User) {
        repository.getUser(user)
    }
}