package com.example.fitapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitapp.domain.entities.Exercise
import com.example.fitapp.domain.usecases.GetAllExercisesUseCase
import com.example.fitapp.domain.usecases.EmailSignInUseCase
import com.example.fitapp.domain.usecases.EmailSignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val getAllExercisesUseCase: GetAllExercisesUseCase,
    private val emailSignInUseCase: EmailSignUpUseCase,
    private val emailSignUpUseCase: EmailSignInUseCase
): ViewModel() {
    private val _exercises = MutableStateFlow<List<Exercise>>(emptyList())
    val exercises: StateFlow<List<Exercise>> = _exercises.asStateFlow()

    fun getAllExercises() {
        viewModelScope.launch {
            try {
                _exercises.value = getAllExercisesUseCase.execute()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun emailSignUp(email: String, password: String) {
        viewModelScope.launch {
            try {
                emailSignUpUseCase.execute(email, password)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun emailSignIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                emailSignInUseCase.execute(email, password)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}