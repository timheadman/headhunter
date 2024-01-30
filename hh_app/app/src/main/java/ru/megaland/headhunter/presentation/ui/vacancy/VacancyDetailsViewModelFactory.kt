package ru.megaland.headhunter.presentation.ui.vacancy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.megaland.headhunter.domain.usecase.GetVacancyByIdUseCase

class VacancyDetailsViewModelFactory(
    val getVacancyByIdUseCase: GetVacancyByIdUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VacancyDetailsViewModel(
            getVacancyByIdUseCase = getVacancyByIdUseCase,
        ) as T
    }

}