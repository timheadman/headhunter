package ru.megaland.kd06.data.storage.company

import ru.megaland.kd06.data.storage.model.company.CompanyData
import ru.megaland.kd06.data.storage.model.company.CompanyShortData

interface CompanyStorage {
    fun getAllCompanies(): List<CompanyShortData>
    fun getCompanyById(companyId: String): CompanyData?

}