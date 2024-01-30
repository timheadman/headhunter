package ru.megaland.headhunter.presentation.usecase

import ru.megaland.headhunter.domain.model.company.Company
import ru.megaland.headhunter.domain.repository.CompanyRepository
import ru.megaland.headhunter.domain.usecase.GetCompanyByIdUseCase

class GetCompanyByIdUseCaseImpl (private val companyRepository: CompanyRepository): GetCompanyByIdUseCase {
    override suspend fun execute(id: String): Company {
        return companyRepository.getCompanyById(id)
    }
}

