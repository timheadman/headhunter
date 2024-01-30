package ru.megaland.headhunter.domain.model.candidate

data class JobExperience(
    val dateStart: String,
    val dateEnd: String,
    val companyName: String,
    val description: String,
)