package ru.megaland.kd06.domain.model.company

import kotlinx.serialization.Serializable

@Serializable
data class Vacancy(
    val id: String,
    val companyId: String,
    val profession: String,
    val level: String,
    val salary: Long,
    val description: String,
)
