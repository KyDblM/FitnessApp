package com.example.fitapp.data.repository

import android.util.Log
import com.example.fitapp.data.entities.ExerciseDTO
import com.example.fitapp.data.mappers.toDomain
import com.example.fitapp.domain.entities.Exercise
import com.example.fitapp.domain.repository.ExerciseRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns

class ExerciseRepositoryImpl : ExerciseRepository {
    override suspend fun getAllExercises(database: SupabaseClient): List<Exercise> {

        return database
            .from("exercises")
            .select(
                Columns.raw(
                "id, categories(id, name), equipment(id, name), difficulty_levels(id, difficulty), image_url, video_url"
                )
            )
            .decodeList<ExerciseDTO>()
            .map { it.toDomain() }
            .sortedBy { it.id }
    }
}