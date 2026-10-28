package com.example.fitapp.domain.entities

data class Exercise(
    val id: Int,
    val category: String,
    val equipment: String,
    val difficultyLevel: String,
    val image: String,
    val video: String,
)