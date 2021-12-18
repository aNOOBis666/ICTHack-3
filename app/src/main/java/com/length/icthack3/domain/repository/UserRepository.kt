package com.length.icthack3.domain.repository

import com.length.icthack3.domain.model.User

interface UserRepository {

    suspend fun addUser(user: User)

    suspend fun deleteUser(user: User)

    suspend fun editUser(user: User)

    suspend fun getUser(userId: String): User?
}