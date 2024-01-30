package ru.megaland.headhunter.domain.usecase

import ru.megaland.headhunter.domain.model.candidate.Candidate

interface GetCandidateByIdUseCase {
    suspend fun execute(id: String): Candidate
}