package ru.megaland.headhunter.data.storage

import ru.megaland.headhunter.data.model.company.VacancyData
import ru.megaland.headhunter.data.model.company.VacancyShortData

interface VacancyStorage {
    suspend fun getAllVacancies(): List<VacancyShortData>
    suspend fun getVacancyById(id: String): VacancyData

}