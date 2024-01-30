package ru.megaland.headhunter.presentation.ui.company

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.megaland.headhunter.domain.usecase.GetCompanyByIdUseCase

class CompanyDetailsViewModelFactory(
    val getCompanyByIdUseCase: GetCompanyByIdUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CompanyDetailsViewModel(
            getCompanyByIdUseCase = getCompanyByIdUseCase,
        ) as T
    }

}