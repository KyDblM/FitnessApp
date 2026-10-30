package com.example.fitapp.domain.usecases

import com.example.fitapp.domain.repository.SignInRepository
import io.github.jan.supabase.SupabaseClient

class EmailSignInUseCase (private val signInRepository: SignInRepository) {
    suspend fun execute(database: SupabaseClient, email: String, password: String) {
        signInRepository.emailSignIn(database, email, password)
    }
}