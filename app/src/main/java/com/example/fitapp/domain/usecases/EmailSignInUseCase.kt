package com.example.fitapp.domain.usecases

import com.example.fitapp.domain.repository.SignInRepository
import javax.inject.Inject

class EmailSignInUseCase @Inject constructor(
    private val signInRepository: SignInRepository
) {
    suspend fun execute(email: String, password: String) {
        signInRepository.emailSignIn(email, password)
    }
}