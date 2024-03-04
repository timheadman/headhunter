package ru.megaland.headhunter.data.storage.vacancy

import ru.megaland.headhunter.data.model.company.VacancyData
import ru.megaland.headhunter.data.model.company.VacancyShortData

class VacancyStorageApiImpl (private val retrofitApi: VacancyStorageApi): VacancyStorageApi {
    override suspend fun getAllVacancies(): List<VacancyShortData> {
        return retrofitApi.getAllVacancies()
    }

    override suspend fun getVacancyById(id: String): VacancyData {
        return retrofitApi.getVacancyById(id)
    }
}