package ru.megaland.headhunter.domain.model.candidate
data class Education(
    val type: String,
    val yearStart: Int,
    val yearEnd: Int,
    val description: String,
)