package ru.megaland.kd06.domain.model.company

import kotlinx.serialization.Serializable

@Serializable
data class CompanyShort(
    val id: String,
    val name: String,
    val industry: String,
)
