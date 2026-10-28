package com.example.fitapp.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class Equipment(
    val id: Int,
    val name: String,
)