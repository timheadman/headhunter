package ru.megaland.kd06.presentation.usecase

import ru.megaland.kd06.domain.model.candidate.Candidate
import ru.megaland.kd06.domain.repository.candidate.CandidateRepository
import ru.megaland.kd06.domain.usecase.candidate.SaveCandidateUseCase

class SaveCandidateUseCaseImpl(private val candidateRepository: CandidateRepository) : SaveCandidateUseCase {
    override fun execute(candidate: Candidate) {
        candidateRepository.saveResume(candidate)
    }

}
