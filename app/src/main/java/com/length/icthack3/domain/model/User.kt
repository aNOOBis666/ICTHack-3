package com.length.icthack3.domain.model

import com.google.firebase.firestore.Exclude

class User(
    @Exclude
    val id: String,

    val username: String = "",
    val balance: Double = 0.0,
    val token: String = "",
    val exchangeToken: String = "",
    val type: Int = TYPE_STUDENT
) {
    companion object {
        const val TABLE_NAME = "User"
        const val TYPE_TEACHER = 1
        const val TYPE_STUDENT = 0
    }
}