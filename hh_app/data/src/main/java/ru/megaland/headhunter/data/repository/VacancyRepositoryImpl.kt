package ru.megaland.headhunter.data.repository

import ru.megaland.headhunter.data.model.company.VacancyData
import ru.megaland.headhunter.data.model.company.VacancyShortData
import ru.megaland.headhunter.data.storage.VacancyStorage
import ru.megaland.headhunter.domain.model.company.Vacancy
import ru.megaland.headhunter.domain.model.company.VacancyShort
import ru.megaland.headhunter.domain.repository.VacancyRepository

class VacancyRepositoryImpl(private val vacancyStorage: VacancyStorage) : VacancyRepository {

    override suspend fun getAllVacancies(): List<VacancyShort> {
        return mapVacancyShortListToVacancyShortDataList(vacancyStorage.getAllVacancies())
    }

    override suspend fun getVacancyById(vacancyId: String): Vacancy {
        return vacancyStorage.getVacancyById(vacancyId).toVacancy()

    }

    private fun VacancyData.toVacancy(): Vacancy {
        return Vacancy(
            id = this.id,
            companyId = this.companyId,
            profession = this.profession,
            level = this.level,
            salary = this.salary,
            description = this.description,
        )
    }

    private fun VacancyShortData.toVacancyShort(): VacancyShort {
        return VacancyShort(
            id = this.id,
            company = this.company,
            profession = this.profession,
            level = this.level,
            salary = this.salary,
        )
    }

    private fun mapVacancyShortListToVacancyShortDataList(data: List<VacancyShortData>): List<VacancyShort> {
        return data.map { it.toVacancyShort() }
    }


}
