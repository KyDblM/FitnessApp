package com.example.fitapp.domain.usecases

import com.example.fitapp.domain.entities.Exercise
import com.example.fitapp.domain.repository.ExerciseRepository
import io.github.jan.supabase.SupabaseClient

class GetAllExercisesUseCase(private val exerciseRepository: ExerciseRepository) {
    suspend fun execute(database: SupabaseClient) : List<Exercise> {
        return exerciseRepository.getAllExercises(database)
    }
}