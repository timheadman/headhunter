package ru.megaland.kd06.data.storage.model.candidate

data class CandidateData(
    val id: String,
    val candidateInfo: CandidateInfoData,
    val education: List<EducationData>,
    val jobExperience: List<JobExperienceData>,
    val description: String,
    val tags: List<TagData>
)
