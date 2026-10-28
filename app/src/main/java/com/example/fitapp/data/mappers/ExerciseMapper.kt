package com.example.fitapp.data.mappers

import com.example.fitapp.data.entities.ExerciseDTO
import com.example.fitapp.domain.entities.Exercise

fun ExerciseDTO.toDomain() : Exercise {
    return Exercise(
        id = id,
        category = categories.name,
        equipment = equipment.name,
        difficultyLevel = difficulty_levels.difficulty,
        image = image_url,
        video = video_url,
    )
}