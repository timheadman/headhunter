package ru.megaland.headhunter.domain.usecase

import ru.megaland.headhunter.domain.model.company.Vacancy

interface GetVacancyByIdUseCase {
    suspend fun execute(id: String): Vacancy
}