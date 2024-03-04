package ru.megaland.headhunter.data.storage.candidate

import ru.megaland.headhunter.data.model.candidate.CandidateData

interface CandidateStorage {
    suspend fun getCandidateById(id: String): CandidateData
}