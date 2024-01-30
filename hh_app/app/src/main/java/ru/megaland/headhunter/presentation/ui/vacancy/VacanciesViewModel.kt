package ru.megaland.headhunter.presentation.ui.vacancy

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.megaland.headhunter.domain.model.company.VacancyShort
import ru.megaland.headhunter.domain.usecase.GetAllVacanciesUseCase
import java.net.SocketTimeoutException

class VacanciesViewModel(
    private val getAllVacanciesUseCase: GetAllVacanciesUseCase,
) : ViewModel() {

    val liveAllVacanciesList = MutableLiveData<List<VacancyShort>>()
    var liveToast = MutableLiveData<String>()

    init {
        Log.d("--->", "VacanciesViewModel [init] - Start")
    }

    override fun onCleared() {
        Log.d("--->", "VacanciesViewModel [onCleared] - Start")
        super.onCleared()
    }

    fun getAllVacancies() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val allVacanciesList = getAllVacanciesUseCase.execute()
                liveAllVacanciesList.postValue(allVacanciesList)
                Log.d("--->", "VacanciesViewModel [getAllVacancies]: $allVacanciesList")
            } catch (e: SocketTimeoutException) {
                liveToast.postValue(e.message)
                Log.e("--->", "VacanciesViewModel [getAllVacancies]: Timeout Exception: ${e.message}")
            } catch (e: Exception) {
                liveToast.postValue(e.message)
                Log.e("--->", "VacanciesViewModel [getAllVacancies]: Exception: ${e.message}")
            }
        }
    }

}