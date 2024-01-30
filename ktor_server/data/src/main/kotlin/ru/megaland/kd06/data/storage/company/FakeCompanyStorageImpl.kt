package ru.megaland.kd06.data.storage.company

import ru.megaland.kd06.data.storage.model.company.CompanyData
import ru.megaland.kd06.data.storage.model.company.CompanyShortData

class FakeCompanyStorageImpl : CompanyStorage {
    private val companies = listOf(
        CompanyData("1", "OOO SuperPay", "Banking", "79815354235"),
        CompanyData("77", "MTM", "Banking", "+79152354834"),
        CompanyData("763", "CryptoSuperGo", "Banking", "+79152354834"),
        CompanyData("7655", "PlatiNalogi", "Public Services", "88004846512"),
        CompanyData("71", "NeftGazIkra", "Public Services", "79485156458"),
        CompanyData("36", "OOO SoftForHomies", "IT", "89785455654"),
        CompanyData("79", "MobileGamesPro", "IT", "+79845255456"),
        CompanyData("238", "FoodsAndGoods", "Public Services", "+79876542125"),
        CompanyData("39", "VseIgry", "IT", "89615654485"),
        CompanyData("1440", "ItBankingMax", "Banking", "77778889811"),
    )

    private val companiesShort : List<CompanyShortData> = companies.map {
        CompanyShortData(it.id, it.name, it.industry)
    }

    override fun getAllCompanies(): List<CompanyShortData> {
        return companiesShort
    }

    override fun getCompanyById(companyId: String): CompanyData? {
        return companies.find { it.id == companyId }
    }
}