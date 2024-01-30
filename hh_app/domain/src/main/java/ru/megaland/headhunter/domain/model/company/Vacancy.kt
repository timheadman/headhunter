package ru.megaland.headhunter.domain.model.company

data class Vacancy(
    val id: String,
    val companyId: String,
    val profession: String,
    val level: String,
    val salary: Long,
    val description: String,
)
