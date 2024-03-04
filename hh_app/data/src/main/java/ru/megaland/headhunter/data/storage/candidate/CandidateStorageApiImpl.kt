package ru.megaland.headhunter.data.storage.candidate

import ru.megaland.headhunter.data.model.candidate.CandidateData

class CandidateStorageApiImpl (private val retrofitApi: CandidateStorageApi): CandidateStorageApi {
    override suspend fun getCandidateById(id: String): CandidateData {
        return retrofitApi.getCandidateById(id)
    }
}