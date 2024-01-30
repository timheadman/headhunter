package ru.megaland.headhunter.presentation.usecase

import ru.megaland.headhunter.domain.model.company.VacancyShort
import ru.megaland.headhunter.domain.repository.VacancyRepository
import ru.megaland.headhunter.domain.usecase.GetAllVacanciesUseCase

class GetAllVacanciesUseCaseImpl(private val vacancyRepository: VacancyRepository) :
    GetAllVacanciesUseCase {
    override suspend fun execute(): List<VacancyShort> {
        return vacancyRepository.getAllVacancies()
    }
}