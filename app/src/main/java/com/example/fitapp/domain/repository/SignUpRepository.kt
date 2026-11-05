package com.example.fitapp.domain.repository

interface SignUpRepository {
    suspend fun emailSignUp(email: String, password: String)
}