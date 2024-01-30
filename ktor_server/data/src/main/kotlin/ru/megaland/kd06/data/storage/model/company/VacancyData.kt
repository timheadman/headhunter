package ru.megaland.kd06.data.storage.model.company

data class VacancyData(
    val id: String,
    val companyId: String,
    val profession: String,
    val level: String,
    val salary: Long,
    val description: String,
)
