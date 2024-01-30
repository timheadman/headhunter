package ru.megaland.headhunter.domain.repository

import ru.megaland.headhunter.domain.model.candidate.Candidate

interface CandidateRepository {
    suspend fun getCandidateById(id: String): Candidate
}