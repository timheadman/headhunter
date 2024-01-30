package ru.megaland.headhunter.data.model.candidate

data class EducationData(
    val type: String,
    val yearStart: Int,
    val yearEnd: Int,
    val description: String,
)