package ru.megaland.kd06.data.repository.company

import ru.megaland.kd06.data.storage.company.VacancyStorage
import ru.megaland.kd06.data.storage.model.company.VacancyData
import ru.megaland.kd06.data.storage.model.company.VacancyShortData
import ru.megaland.kd06.domain.model.company.Vacancy
import ru.megaland.kd06.domain.model.company.VacancyShort
import ru.megaland.kd06.domain.repository.company.VacancyRepository

class VacancyRepositoryImpl(private val vacancyStorage: VacancyStorage) : VacancyRepository {

    override fun getAllVacancies(): List<VacancyShort> {
        return mapVacancyShortListToVacancyShortDataList(vacancyStorage.getAllVacancies())
    }

    override fun getVacancyById(vacancyId: String): Vacancy? {
        return vacancyStorage.getVacancyById(vacancyId)?.toVacancy()

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
