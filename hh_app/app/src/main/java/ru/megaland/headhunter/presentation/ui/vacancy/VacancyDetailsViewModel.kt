package ru.megaland.headhunter.presentation.ui.vacancy

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.megaland.headhunter.domain.model.company.Vacancy
import ru.megaland.headhunter.domain.usecase.GetVacancyByIdUseCase
import java.net.SocketTimeoutException

class VacancyDetailsViewModel(
    private val getVacancyByIdUseCase: GetVacancyByIdUseCase,
) : ViewModel() {
    val liveVacancyById = MutableLiveData<Vacancy>()
    val liveToast = MutableLiveData<String>()

    init {
        Log.d("--->", "VacancyDetailsViewModel [init] - Start")
    }

    override fun onCleared() {
        Log.d("--->", "VacancyDetailsViewModel [onCleared] - Start")
        super.onCleared()
    }

    fun getVacancyById(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val vacancyById = getVacancyByIdUseCase.execute(id)
                liveVacancyById.postValue(vacancyById)
                Log.d("--->", "VacancyDetailsViewModel [getVacancyById]: $vacancyById")
            } catch (e: SocketTimeoutException) {
                liveToast.postValue(e.message)
                Log.e("--->", "VacancyDetailsViewModel [getVacancyById]: Timeout Exception: ${e.message}")
            } catch (e: Exception) {
                liveToast.postValue(e.message)
                Log.e("--->", "VacancyDetailsViewModel [getVacancyById]: Exception: ${e.message}")
            }
        }
    }

}