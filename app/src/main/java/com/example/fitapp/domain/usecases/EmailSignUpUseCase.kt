package com.example.fitapp.domain.usecases

import com.example.fitapp.domain.repository.SignUpRepository
import io.github.jan.supabase.SupabaseClient

class EmailSignUpUseCase(private val signUpRepository: SignUpRepository) {
    suspend fun execute(database: SupabaseClient, email: String, password: String) {
        return signUpRepository.emailSignUp(database, email, password)
    }
}