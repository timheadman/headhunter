package ru.megaland.headhunter.presentation.ui.company

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.megaland.headhunter.domain.usecase.GetAllCompaniesUseCase

class CompaniesViewModelFactory(
    val getAllCompaniesUseCase: GetAllCompaniesUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CompaniesViewModel(
            getAllCompaniesUseCase = getAllCompaniesUseCase,
        ) as T
    }

}