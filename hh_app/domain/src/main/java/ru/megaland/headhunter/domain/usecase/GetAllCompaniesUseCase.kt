package ru.megaland.headhunter.domain.usecase

import ru.megaland.headhunter.domain.model.company.CompanyShort

interface GetAllCompaniesUseCase {
    suspend fun execute(): List<CompanyShort>
}