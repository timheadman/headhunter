package ru.megaland.headhunter.data.storage

import retrofit2.http.GET
import retrofit2.http.Path
import ru.megaland.headhunter.data.model.company.VacancyData
import ru.megaland.headhunter.data.model.company.VacancyShortData

interface VacancyStorageApi : VacancyStorage {
    @GET("vacancies")
    override suspend fun getAllVacancies(): List<VacancyShortData>

    @GET("vacancy/{id}")
    override suspend fun getVacancyById(@Path("id") id: String): VacancyData
}