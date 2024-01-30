package ru.megaland.kd06.domain.model.candidate

import kotlinx.serialization.Serializable
@Serializable
data class Candidate(
    val id: String,
    val candidateInfo: CandidateInfo,
    val education: List<Education>,
    val jobExperience: List<JobExperience>,
    val description: String,
    val tags: List<Tag>,
)
