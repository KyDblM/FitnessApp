package com.example.fitapp.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class ExerciseDTO(
    val id: Int,
    val categories: Category,
    val equipment: Equipment,
    val difficulty_levels: DifficultyLevel,
    val image_url: String,
    val video_url: String,
)