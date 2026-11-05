package com.example.fitapp.data.repository

import com.example.fitapp.domain.repository.SignUpRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val database: SupabaseClient
) : SignUpRepository {
    override suspend fun emailSignUp(email: String, password: String) {
        database.auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }
    }
}