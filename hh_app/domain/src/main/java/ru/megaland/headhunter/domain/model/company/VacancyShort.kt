package ru.megaland.headhunter.domain.model.company

data class VacancyShort(
    val id: String,
    val company: String,
    val profession: String,
    val level: String,
    val salary: Long,
)
