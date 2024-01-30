package ru.megaland.kd06.presentation.usecase

import ru.megaland.kd06.domain.repository.company.CompanyRepository
import ru.megaland.kd06.domain.model.company.CompanyShort
import ru.megaland.kd06.domain.usecase.company.GetAllCompaniesUseCase

class GetAllCompaniesUseCaseImpl(private val companyRepository: CompanyRepository) : GetAllCompaniesUseCase {
    override fun execute(): List<CompanyShort> {
        return companyRepository.getAllCompanies()
    }

}
