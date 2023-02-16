package com.richmondprojects.myapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ResultsEntity(
    val birth_year: String,
    val created: String,
    val edited: String,
    val eye_color: String,
    val gender: String,
    val hair_color: String,
    val height: String,
    val homeworld: String,
    val mass: String,
    @PrimaryKey
    val name: String,
    val skin_color: String,
    val url: String,
)
