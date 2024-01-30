package ru.megaland.headhunter.domain.usecase

import ru.megaland.headhunter.domain.model.company.Company

interface GetCompanyByIdUseCase {
    suspend fun execute(id: String): Company
}