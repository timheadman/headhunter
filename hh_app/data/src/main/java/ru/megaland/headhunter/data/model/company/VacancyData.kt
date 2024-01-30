package ru.megaland.headhunter.data.model.company

data class VacancyData(
    val id: String,
    val companyId: String,
    val profession: String,
    val level: String,
    val salary: Long,
    val description: String,
)