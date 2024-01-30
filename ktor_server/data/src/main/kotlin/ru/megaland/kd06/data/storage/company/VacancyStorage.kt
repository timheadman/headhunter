package ru.megaland.kd06.data.storage.company

import ru.megaland.kd06.data.storage.model.company.VacancyData
import ru.megaland.kd06.data.storage.model.company.VacancyShortData

interface VacancyStorage {
    fun getAllVacancies(): List<VacancyShortData>
    fun getVacancyById(vacancyId: String): VacancyData?

}