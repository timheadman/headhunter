package ru.megaland.kd06.presentation.usecase

import ru.megaland.kd06.domain.model.company.Company
import ru.megaland.kd06.domain.repository.company.CompanyRepository
import ru.megaland.kd06.domain.usecase.company.GetCompanyByIdUseCase

class GetCompanyByIdUseCaseImpl(private val companyRepository: CompanyRepository) : GetCompanyByIdUseCase {
    override fun execute(companyId: String): Company? {
        return companyRepository.getCompanyById(companyId)
    }

}
