package com.example.fitapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitapp.data.repository.ExerciseRepositoryImpl
import com.example.fitapp.domain.entities.Exercise
import com.example.fitapp.domain.usecases.GetAllExercisesUseCase
import com.example.fitapp.BuildConfig
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {
    val database = createSupabaseClient(
        supabaseUrl = BuildConfig.SUPABASE_URL,
        supabaseKey = BuildConfig.SUPABASE_KEY
    ) {
        install(Postgrest)
    }

    private val exerciseRepository = ExerciseRepositoryImpl()
    private val getAllExercisesUseCase = GetAllExercisesUseCase(exerciseRepository)

    private val _exercises = MutableStateFlow<List<Exercise>>(emptyList())
    val exercises: StateFlow<List<Exercise>> = _exercises.asStateFlow()

    fun getAllExercises() {
        viewModelScope.launch {
            try {
                _exercises.value = getAllExercisesUseCase.execute(database)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}