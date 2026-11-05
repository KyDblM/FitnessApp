package com.example.fitapp.domain.repository

interface SignInRepository {
    suspend fun emailSignIn(email: String, password: String)
}