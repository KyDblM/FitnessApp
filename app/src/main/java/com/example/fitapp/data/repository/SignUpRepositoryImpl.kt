package com.example.fitapp.data.repository

import com.example.fitapp.domain.repository.SignUpRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class SignUpRepositoryImpl : SignUpRepository {
    override suspend fun emailSignUp(database: SupabaseClient, email: String, password: String) {
        database.auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }
    }
}