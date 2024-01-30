package ru.megaland.kd06.data.repository.company

import ru.megaland.kd06.data.storage.company.CompanyStorage
import ru.megaland.kd06.data.storage.model.company.CompanyData
import ru.megaland.kd06.data.storage.model.company.CompanyShortData
import ru.megaland.kd06.domain.model.company.Company
import ru.megaland.kd06.domain.model.company.CompanyShort
import ru.megaland.kd06.domain.repository.company.CompanyRepository

class CompanyRepositoryImpl(private val companyStorage: CompanyStorage) : CompanyRepository {
    override fun getAllCompanies(): List<CompanyShort> {
        return mapCompanyShortListToCompanyShortDataList(companyStorage.getAllCompanies())
    }

    override fun getCompanyById(companyId: String): Company? {
        return companyStorage.getCompanyById(companyId)?.toCompany()
    }

    private fun CompanyData.toCompany(): Company {
        return Company(
            id = this.id,
            name = this.name,
            industry = this.industry,
            contacts = this.contacts,
        )
    }

    private fun CompanyShortData.toCompanyShort(): CompanyShort {
        return CompanyShort(
            id = this.id,
            name = this.name,
            industry = this.industry,
        )
    }

    private fun mapCompanyShortListToCompanyShortDataList(data: List<CompanyShortData>): List<CompanyShort> {
        return data.map { it.toCompanyShort() }
    }

}
