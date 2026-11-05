package com.example.fitapp.domain.repository

import com.example.fitapp.domain.entities.Exercise

interface ExerciseRepository {
    suspend fun getAllExercises() : List<Exercise>
}