package ru.megaland.headhunter.data.storage

import ru.megaland.headhunter.data.model.candidate.CandidateData

interface CandidateStorage {
    suspend fun getCandidateById(id: String): CandidateData
}