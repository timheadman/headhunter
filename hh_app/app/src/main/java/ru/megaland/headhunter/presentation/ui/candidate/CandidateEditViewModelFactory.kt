package ru.megaland.headhunter.presentation.ui.candidate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.megaland.headhunter.domain.usecase.GetCandidateByIdUseCase

class CandidateEditViewModelFactory(
    val getCandidateByIdUseCase: GetCandidateByIdUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CandidateEditViewModel(
            getCandidateByIdUseCase = getCandidateByIdUseCase,
        ) as T // TODO: Unchecked cast
    }

}