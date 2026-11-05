package com.example.fitapp.domain.usecases

import com.example.fitapp.domain.repository.SignUpRepository
import javax.inject.Inject

class EmailSignUpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository
) {
    suspend fun execute(email: String, password: String) {
        return signUpRepository.emailSignUp(email, password)
    }
}