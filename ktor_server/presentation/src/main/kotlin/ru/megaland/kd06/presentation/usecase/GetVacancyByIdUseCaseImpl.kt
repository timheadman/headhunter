package ru.megaland.kd06.presentation.usecase

import ru.megaland.kd06.domain.model.company.Vacancy
import ru.megaland.kd06.domain.repository.company.VacancyRepository
import ru.megaland.kd06.domain.usecase.company.GetVacancyByIdUseCase

class GetVacancyByIdUseCaseImpl(private val vacancyRepository: VacancyRepository) : GetVacancyByIdUseCase {
    override fun execute(vacancyId: String): Vacancy? {
        return vacancyRepository.getVacancyById(vacancyId)
    }

}
