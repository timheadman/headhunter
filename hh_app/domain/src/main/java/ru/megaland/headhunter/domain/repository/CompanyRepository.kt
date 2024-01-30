package ru.megaland.headhunter.domain.repository

import ru.megaland.headhunter.domain.model.company.Company
import ru.megaland.headhunter.domain.model.company.CompanyShort

interface CompanyRepository {
    suspend fun getAllCompanies(): List<CompanyShort>
    suspend fun getCompanyById(id: String): Company
}