package ru.megaland.headhunter.data.repository

import ru.megaland.headhunter.data.model.candidate.CandidateData
import ru.megaland.headhunter.data.model.candidate.CandidateInfoData
import ru.megaland.headhunter.data.model.candidate.ContactsData
import ru.megaland.headhunter.data.model.candidate.EducationData
import ru.megaland.headhunter.data.model.candidate.JobExperienceData
import ru.megaland.headhunter.data.storage.CandidateStorageApiImpl
import ru.megaland.headhunter.domain.model.candidate.Candidate
import ru.megaland.headhunter.domain.model.candidate.CandidateInfo
import ru.megaland.headhunter.domain.model.candidate.Contacts
import ru.megaland.headhunter.domain.model.candidate.Education
import ru.megaland.headhunter.domain.model.candidate.JobExperience
import ru.megaland.headhunter.domain.model.candidate.Tag
import ru.megaland.headhunter.domain.repository.CandidateRepository

class CandidateRepositoryImpl(private val candidateStorage: CandidateStorageApiImpl) :
    CandidateRepository {
    override suspend fun getCandidateById(id: String): Candidate {
        return candidateStorage.getCandidateById(id).toCandidate()
    }

    private fun CandidateData.toCandidate(): Candidate {
        return Candidate(
            id = this.id,
            candidateInfo = this.candidateInfo.toCandidateInfo(),
            education = this.education.map { it.toEducation() },
            jobExperience = this.jobExperience.map { it.toJobExperience() },
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
            contacts = this.contacts.toContacts(),
            relocation = this.relocation,
        )
    }

    private fun ContactsData.toContacts(): Contacts {
        return Contacts(
            email = this.email,
            phone = this.phone,
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
            description = this.description
        )
    }
}