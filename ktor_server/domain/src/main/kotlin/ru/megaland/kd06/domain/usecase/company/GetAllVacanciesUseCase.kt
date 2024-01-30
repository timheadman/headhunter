package ru.megaland.kd06.domain.usecase.company

import ru.megaland.kd06.domain.model.company.VacancyShort

interface GetAllVacanciesUseCase {
    fun execute(): List<VacancyShort>

}
