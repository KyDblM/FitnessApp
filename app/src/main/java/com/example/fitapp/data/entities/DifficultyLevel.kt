package com.example.fitapp.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class DifficultyLevel(
    val id: Int,
    val difficulty: String,
)
