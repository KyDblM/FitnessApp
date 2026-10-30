package com.example.fitapp.domain.repository

import io.github.jan.supabase.SupabaseClient

interface SignUpRepository {
    suspend fun emailSignUp(database: SupabaseClient, email: String, password: String)
}