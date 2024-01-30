package ru.megaland.kd06.domain.repository.company

import ru.megaland.kd06.domain.model.company.Company
import ru.megaland.kd06.domain.model.company.CompanyShort

interface CompanyRepository {
    fun getAllCompanies(): List<CompanyShort>
    fun getCompanyById(companyId: String): Company?
}