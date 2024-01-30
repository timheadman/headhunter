package ru.megaland.kd06.domain.model.company

import kotlinx.serialization.Serializable
@Serializable
data class Company(
    val id: String,
    val name: String,
    val industry: String,
    val contacts: String
)
