package ru.megaland.kd06.domain.model.candidate
import kotlinx.serialization.Serializable
@Serializable
data class Education(
    val type: String,
    val yearStart: Int,
    val yearEnd: Int,
    val description: String,
)