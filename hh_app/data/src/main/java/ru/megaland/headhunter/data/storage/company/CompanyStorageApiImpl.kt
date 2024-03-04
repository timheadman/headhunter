package ru.megaland.headhunter.data.storage.company

import ru.megaland.headhunter.data.model.company.CompanyData
import ru.megaland.headhunter.data.model.company.CompanyShortData

class CompanyStorageApiImpl (private val retrofitApi: CompanyStorageApi): CompanyStorageApi {
    override suspend fun getAllCompanies(): List<CompanyShortData> {
        return retrofitApi.getAllCompanies()
    }

    override suspend fun getCompanyById(id: String): CompanyData {
        return retrofitApi.getCompanyById(id)
    }
}