package ru.megaland.headhunter.presentation.ui.vacancy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.megaland.headhunter.domain.usecase.GetAllVacanciesUseCase

class VacanciesViewModelFactory(
    val getAllVacanciesUseCase: GetAllVacanciesUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VacanciesViewModel(
            getAllVacanciesUseCase = getAllVacanciesUseCase,
        ) as T
    }

}