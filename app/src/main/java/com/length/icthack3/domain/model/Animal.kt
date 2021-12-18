package com.length.icthack3.domain.model

import com.google.firebase.firestore.Exclude

data class Animal(
    @Exclude
    private val id: String,

    private val ownerId: String,
    private val type: String,
    private val name: String,
    private val income: Double = when (type) {
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
