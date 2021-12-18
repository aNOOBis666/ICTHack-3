package com.length.icthack3.domain.repository

import com.length.icthack3.domain.model.User

interface UserRepository {

    fun getUser(user: User): User

    fun deleteUser(user: User)

    fun editUser(user: User)
}