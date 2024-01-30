package ru.megaland.headhunter.presentation.usecase

import ru.megaland.headhunter.domain.model.company.Vacancy
import ru.megaland.headhunter.domain.repository.VacancyRepository
import ru.megaland.headhunter.domain.usecase.GetVacancyByIdUseCase

class GetVacancyByIdUseCaseImpl (private val vacancyRepository: VacancyRepository):
    GetVacancyByIdUseCase {
    override suspend fun execute(id: String): Vacancy {
        return vacancyRepository.getVacancyById(id)
    }
}

