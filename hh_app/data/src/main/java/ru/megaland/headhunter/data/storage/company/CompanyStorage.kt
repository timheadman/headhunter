package ru.megaland.headhunter.data.storage.company

import ru.megaland.headhunter.data.model.company.CompanyData
import ru.megaland.headhunter.data.model.company.CompanyShortData

interface CompanyStorage {
    suspend fun getAllCompanies(): List<CompanyShortData>
    suspend fun getCompanyById(id: String): CompanyData
}