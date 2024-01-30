package ru.megaland.kd06.domain.usecase.company

import ru.megaland.kd06.domain.model.company.Vacancy

interface GetVacancyByIdUseCase {
    fun execute(vacancyId: String): Vacancy?

}
