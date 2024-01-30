package ru.megaland.kd06.domain.repository.candidate

import ru.megaland.kd06.domain.model.candidate.Candidate

interface CandidateRepository {
    fun getCandidateById(candidateId: String): Candidate?
    fun saveResume(candidate: Candidate)

}