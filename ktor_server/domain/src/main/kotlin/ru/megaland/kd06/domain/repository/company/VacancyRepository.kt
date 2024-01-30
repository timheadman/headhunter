package ru.megaland.kd06.domain.repository.company

import ru.megaland.kd06.domain.model.company.Vacancy
import ru.megaland.kd06.domain.model.company.VacancyShort

interface VacancyRepository {
    fun getAllVacancies(): List<VacancyShort>
    fun getVacancyById(vacancyId: String): Vacancy?

}