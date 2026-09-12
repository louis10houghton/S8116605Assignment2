package com.example.s8116605assignment2.network.model
import java.io.Serializable

data class Entity(
    val technique: String,
    val equipment: String,
    val subject: String,
    val pioneeringPhotographer: String,
    val yearIntroduced: Long,
    val description: String,
): Serializable
