package com.example.fitapp.data.repository

import com.example.fitapp.domain.repository.SignInRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class SignInRepositoryImpl : SignInRepository {
    override suspend fun emailSignIn(database: SupabaseClient, email: String, password: String) {
        database.auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }
}