package com.example.fitapp.di

import com.example.fitapp.data.repository.ExerciseRepositoryImpl
import com.example.fitapp.data.repository.SignInRepositoryImpl
import com.example.fitapp.data.repository.SignUpRepositoryImpl
import com.example.fitapp.domain.repository.ExerciseRepository
import com.example.fitapp.domain.repository.SignInRepository
import com.example.fitapp.domain.repository.SignUpRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindExerciseRepository(
        implementation: ExerciseRepositoryImpl
    ) : ExerciseRepository

    @Binds
    @Singleton
    abstract fun bindSignUpRepository(
        implementation: SignUpRepositoryImpl
    ): SignUpRepository

    @Binds
    @Singleton
    abstract fun bindSignInRepository(
        implementation: SignInRepositoryImpl
    ) : SignInRepository
}