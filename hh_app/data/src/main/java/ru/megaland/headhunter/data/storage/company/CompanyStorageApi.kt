package ru.megaland.headhunter.data.storage.company

import retrofit2.http.GET
import retrofit2.http.Path
import ru.megaland.headhunter.data.model.company.CompanyData
import ru.megaland.headhunter.data.model.company.CompanyShortData

interface CompanyStorageApi : CompanyStorage {
    @GET("companies")
    override suspend fun getAllCompanies(): List<CompanyShortData>

    @GET("company/{id}")
    override suspend fun getCompanyById(@Path("id") id: String): CompanyData
}