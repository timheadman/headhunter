package ru.megaland.headhunter.domain.repository

import ru.megaland.headhunter.domain.model.company.Vacancy
import ru.megaland.headhunter.domain.model.company.VacancyShort

interface VacancyRepository {
    suspend fun getAllVacancies(): List<VacancyShort>
    suspend fun getVacancyById(vacancyId: String): Vacancy

}