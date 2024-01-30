package ru.megaland.kd06.domain.usecase.company

import ru.megaland.kd06.domain.model.company.CompanyShort

interface GetAllCompaniesUseCase {
    fun execute(): List<CompanyShort>
}