package com.example.fitapp.domain.repository

import com.example.fitapp.domain.entities.Exercise
import io.github.jan.supabase.SupabaseClient

interface ExerciseRepository {
    suspend fun getAllExercises(database: SupabaseClient) : List<Exercise>
}