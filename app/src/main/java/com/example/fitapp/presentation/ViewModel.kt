package com.example.fitapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitapp.data.repository.ExerciseRepositoryImpl
import com.example.fitapp.domain.entities.Exercise
import com.example.fitapp.domain.usecases.GetAllExercisesUseCase
import com.example.fitapp.BuildConfig
import com.example.fitapp.data.repository.SignInRepositoryImpl
import com.example.fitapp.data.repository.SignUpRepositoryImpl
import com.example.fitapp.domain.usecases.EmailSignInUseCase
import com.example.fitapp.domain.usecases.EmailSignUpUseCase
import io.github.jan.supabase.auth.Auth
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
        install(Auth)
    }

    private val exerciseRepository = ExerciseRepositoryImpl()
    private val getAllExercisesUseCase = GetAllExercisesUseCase(exerciseRepository)

    private val signUpRepository = SignUpRepositoryImpl()
    private val emailSignUpUseCase = EmailSignUpUseCase(signUpRepository)

    private val signInRepository = SignInRepositoryImpl()
    private val emailSignInUseCase = EmailSignInUseCase(signInRepository)

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

    fun emailSignUp(email: String, password: String) {
        viewModelScope.launch {
            try {
                emailSignUpUseCase.execute(database, email, password)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun emailSignIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                emailSignInUseCase.execute(database, email, password)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}