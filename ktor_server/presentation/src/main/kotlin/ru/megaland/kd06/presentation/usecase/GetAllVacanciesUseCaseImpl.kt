package ru.megaland.kd06.presentation.usecase

import ru.megaland.kd06.domain.model.company.VacancyShort
import ru.megaland.kd06.domain.repository.company.VacancyRepository
import ru.megaland.kd06.domain.usecase.company.GetAllVacanciesUseCase

class GetAllVacanciesUseCaseImpl(private val vacancyRepository: VacancyRepository) : GetAllVacanciesUseCase {
    override fun execute(): List<VacancyShort> {
        return vacancyRepository.getAllVacancies()
    }

}
