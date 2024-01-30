package ru.megaland.kd06.domain.usecase.candidate

import ru.megaland.kd06.domain.model.candidate.Candidate

interface SaveCandidateUseCase {
    fun execute(candidate: Candidate)
}
