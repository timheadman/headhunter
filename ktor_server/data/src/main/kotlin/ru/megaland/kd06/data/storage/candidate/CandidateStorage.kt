package ru.megaland.kd06.data.storage.candidate

import ru.megaland.kd06.data.storage.model.candidate.CandidateData
import ru.megaland.kd06.domain.model.candidate.Candidate

interface CandidateStorage {
    fun getCandidateById(candidateId: String): CandidateData?
}