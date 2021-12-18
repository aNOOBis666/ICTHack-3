package com.length.icthack3.domain.model

import com.google.firebase.firestore.Exclude

data class Animal(
    @Exclude
    val id: String,

    val ownerId: String = "",
    val type: String = TYPE_PIG,
    val name: String = "",
    val income: Double = when (type) {
        TYPE_PIG -> 1.0
        TYPE_GOOSE -> 2.0
        TYPE_GOAT -> 3.0
        else -> 0.0
    }
) {
   companion object {
       const val TABLE_NAME = "Animal"
       const val TYPE_PIG = "Pig"
       const val TYPE_GOOSE = "Goose"
       const val TYPE_GOAT = "Goat"
   }
}
