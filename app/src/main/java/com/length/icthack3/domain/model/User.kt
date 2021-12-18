package com.length.icthack3.domain.model

import com.google.firebase.firestore.Exclude

class User(
    @Exclude
    private val id: String,

    private val username: String,
    private val balance: Double,
    private val token: String,
    private val exchangeToken: String,
    private val type: String
) {
    companion object {
        const val TABLE_NAME = "User"
        const val TYPE_TEACHER = 1
        const val TYPE_STUDENT = 0
    }
}