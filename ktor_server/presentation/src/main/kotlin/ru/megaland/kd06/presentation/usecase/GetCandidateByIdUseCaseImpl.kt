package ru.megaland.kd06.presentation.usecase

import ru.megaland.kd06.domain.model.candidate.Candidate
import ru.megaland.kd06.domain.repository.candidate.CandidateRepository
import ru.megaland.kd06.domain.usecase.candidate.GetCandidateByIdUseCase

class GetCandidateByIdUseCaseImpl(private val candidateRepository: CandidateRepository) : GetCandidateByIdUseCase {
    override fun execute(candidateId: String): Candidate? {
        return candidateRepository.getCandidateById(candidateId)
    }

}
