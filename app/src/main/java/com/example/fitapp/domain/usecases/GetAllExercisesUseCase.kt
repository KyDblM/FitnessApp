package com.example.fitapp.domain.usecases

import com.example.fitapp.domain.entities.Exercise
import com.example.fitapp.domain.repository.ExerciseRepository
import javax.inject.Inject

class GetAllExercisesUseCase @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) {
    suspend fun execute() : List<Exercise> {
        return exerciseRepository.getAllExercises()
    }
}