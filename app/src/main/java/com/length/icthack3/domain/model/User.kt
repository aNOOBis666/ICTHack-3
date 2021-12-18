package com.length.icthack3.domain.model

import com.google.firebase.firestore.Exclude

class User(
    @Exclude
    val id: String,

    val username: String,
    val balance: Double,
    val token: String,
    val exchangeToken: String,
    val type: String
) {
    companion object {
        const val TABLE_NAME = "User"
        const val TYPE_TEACHER = 1
        const val TYPE_STUDENT = 0
    }
}