package ru.megaland.headhunter.domain.usecase

import ru.megaland.headhunter.domain.model.company.VacancyShort

interface GetAllVacanciesUseCase {
    suspend fun execute(): List<VacancyShort>
}