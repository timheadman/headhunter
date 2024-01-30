package ru.megaland.kd06.data.repository.candidate

import ru.megaland.kd06.data.storage.candidate.CandidateStorage
import ru.megaland.kd06.data.storage.model.candidate.*
import ru.megaland.kd06.domain.model.candidate.*
import ru.megaland.kd06.domain.repository.candidate.CandidateRepository


class CandidateRepositoryImpl(private val candidateStorage: CandidateStorage) : CandidateRepository {
    override fun getCandidateById(candidateId: String): Candidate? {
        return candidateStorage.getCandidateById(candidateId)?.toCandidate()
    }

    override fun saveResume(candidate: Candidate) {
        val resume = candidate.toString()
        println("Saved Resume: $resume")
    }

    private fun CandidateData.toCandidate(): Candidate {
        return Candidate(
            id = this.id,
            candidateInfo = this.candidateInfo.toCandidateInfo(),
            education = mapEducationListDataToEducationList(this.education),
            jobExperience = mapJobExperienceListDataToJobExperienceList(this.jobExperience),
            description = this.description,
            tags = this.tags.map {
                Tag(it.tags)
            }
        )
    }

    private fun CandidateInfoData.toCandidateInfo(): CandidateInfo {
        return CandidateInfo(
            name = this.name,
            profession = this.profession,
            sex = this.sex,
            birthDate = this.birthDate,
            contacts = this.contacts.toContactsData(),
            relocation = this.relocation,
        )
    }

    private fun ContactsData.toContactsData(): Contacts {
        return Contacts(
            phone = this.phone,
            email = this.email,
        )
    }

    private fun EducationData.toEducation(): Education {
        return Education(
            type = this.type,
            yearStart = this.yearStart,
            yearEnd = this.yearEnd,
            description = this.description,
        )
    }

    private fun JobExperienceData.toJobExperience(): JobExperience {
        return JobExperience(
            dateStart = this.dateStart,
            dateEnd = this.dateEnd,
            companyName = this.companyName,
            description = this.description,
        )
    }

    private fun mapEducationListDataToEducationList(data: List<EducationData>): List<Education> {
        return data.map { it.toEducation() }
    }

    private fun mapJobExperienceListDataToJobExperienceList(data: List<JobExperienceData>): List<JobExperience> {
        return data.map { it.toJobExperience() }
    }


}
