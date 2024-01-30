package ru.megaland.headhunter.data.repository

import ru.megaland.headhunter.data.model.company.CompanyData
import ru.megaland.headhunter.data.model.company.CompanyShortData
import ru.megaland.headhunter.data.storage.CompanyStorageApiImpl
import ru.megaland.headhunter.domain.model.company.Company
import ru.megaland.headhunter.domain.model.company.CompanyShort
import ru.megaland.headhunter.domain.repository.CompanyRepository

class CompanyRepositoryImpl(private val companyStorage: CompanyStorageApiImpl) : CompanyRepository {
    override suspend fun getAllCompanies(): List<CompanyShort> {
        return companyStorage.getAllCompanies().map {
            it.toCompanyShort()
        }
    }

    private fun CompanyShortData.toCompanyShort(): CompanyShort {
        return CompanyShort(
            id = this.id,
            name = this.name,
            industry = this.industry,
        )
    }

    override suspend fun getCompanyById(id: String): Company {
        return companyStorage.getCompanyById(id).toCompany()
    }

    private fun CompanyData.toCompany(): Company {
        return Company(
            id = this.id,
            name = this.name,
            industry = this.industry,
            contacts = this.contacts,
        )
    }
}