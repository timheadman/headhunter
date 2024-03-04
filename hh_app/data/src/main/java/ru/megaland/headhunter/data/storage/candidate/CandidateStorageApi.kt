package ru.megaland.headhunter.data.storage.candidate

import retrofit2.http.GET
import retrofit2.http.Path
import ru.megaland.headhunter.data.model.candidate.CandidateData

interface CandidateStorageApi : CandidateStorage {
    @GET("candidate/{id}")
    override suspend fun getCandidateById(@Path("id") id: String): CandidateData
}