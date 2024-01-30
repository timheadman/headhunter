package ru.megaland.kd06.data.storage.company

import ru.megaland.kd06.data.storage.model.company.VacancyData
import ru.megaland.kd06.data.storage.model.company.VacancyShortData

class FakeVacancyStorageImpl : VacancyStorage {
    private val vacancies = listOf(
        VacancyData("1", "OOO SuperPay", "Developer", "Junior", 50000, "Description for Developer Junior"),
        VacancyData("2", "OOO SuperPay", "QA", "Senior", 80000, "Description for QA Senior"),
        VacancyData("3", "OOO SuperPay", "Project Manager", "Senior", 90000, "Description for Project Manager Senior"),
        VacancyData("4", "MTM", "Analyst", "Middle", 70000, "Description for Analyst Middle"),
        VacancyData("5", "CryptoSuperGo", "Developer", "Junior", 50000, "Description for Developer Junior"),
        VacancyData("6", "FoodsAndGoods", "QA", "Senior", 80000, "Description for QA Senior"),
    )

    private val vacanciesShort = vacancies.map {
        VacancyShortData(
            id = it.id,
            company = it.companyId,
            profession = it.profession,
            level = it.level,
            salary = it.salary,
        )
    }

    override fun getAllVacancies(): List<VacancyShortData> {
        return vacanciesShort
    }

    override fun getVacancyById(vacancyId: String): VacancyData? {
        return vacancies.find { it.id == vacancyId }
    }


}