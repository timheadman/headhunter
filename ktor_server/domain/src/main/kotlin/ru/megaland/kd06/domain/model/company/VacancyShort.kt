package ru.megaland.kd06.domain.model.company

import kotlinx.serialization.Serializable

@Serializable
data class VacancyShort(
    val id: String,
    val company: String,
    val profession: String,
    val level: String,
    val salary: Long,
)
