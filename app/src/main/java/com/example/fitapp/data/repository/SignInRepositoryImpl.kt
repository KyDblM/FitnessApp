package com.example.fitapp.data.repository

import com.example.fitapp.domain.repository.SignInRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val database: SupabaseClient
) : SignInRepository {
    override suspend fun emailSignIn(email: String, password: String) {
        database.auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }
}