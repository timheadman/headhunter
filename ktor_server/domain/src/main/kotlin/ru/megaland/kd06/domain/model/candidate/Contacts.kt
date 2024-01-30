package ru.megaland.kd06.domain.model.candidate
import kotlinx.serialization.Serializable
@Serializable
data class Contacts(
    val phone: String,
    val email: String,
)
