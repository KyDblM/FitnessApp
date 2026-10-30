package com.example.fitapp.domain.repository

import io.github.jan.supabase.SupabaseClient

interface SignInRepository {
    suspend fun emailSignIn(database: SupabaseClient, email: String, password: String)
}