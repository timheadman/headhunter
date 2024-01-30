package ru.megaland.headhunter.data.model.company

data class VacancyShortData(
    val id: String,
    val company: String,
    val profession: String,
    val level: String,
    val salary: Long,
)