package ru.megaland.headhunter.presentation.usecase

import ru.megaland.headhunter.domain.model.company.CompanyShort
import ru.megaland.headhunter.domain.repository.CompanyRepository
import ru.megaland.headhunter.domain.usecase.GetAllCompaniesUseCase

class GetAllCompaniesUseCaseImpl (private val companyRepository: CompanyRepository) : GetAllCompaniesUseCase {
    override suspend fun execute(): List<CompanyShort> {
        return companyRepository.getAllCompanies()
    }
}