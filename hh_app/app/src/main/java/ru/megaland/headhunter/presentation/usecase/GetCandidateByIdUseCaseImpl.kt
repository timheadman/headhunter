package ru.megaland.headhunter.presentation.usecase

import ru.megaland.headhunter.domain.model.candidate.Candidate
import ru.megaland.headhunter.domain.repository.CandidateRepository
import ru.megaland.headhunter.domain.usecase.GetCandidateByIdUseCase

class GetCandidateByIdUseCaseImpl (private val candidateRepository: CandidateRepository):
    GetCandidateByIdUseCase {
    override suspend fun execute(id: String): Candidate {
        return candidateRepository.getCandidateById(id)
    }
}

