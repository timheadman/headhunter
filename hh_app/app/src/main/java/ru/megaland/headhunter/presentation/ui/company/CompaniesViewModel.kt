package ru.megaland.headhunter.presentation.ui.company

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.megaland.headhunter.domain.model.company.CompanyShort
import ru.megaland.headhunter.domain.usecase.GetAllCompaniesUseCase
import java.net.SocketTimeoutException

class CompaniesViewModel(
    private val getAllCompaniesUseCase: GetAllCompaniesUseCase,
) : ViewModel() {

    val liveAllCompaniesList = MutableLiveData<List<CompanyShort>>()
    var liveToast = MutableLiveData<String>()

    init {
        Log.d("--->", "CompaniesViewModel [init]: Start")
    }

    override fun onCleared() {
        Log.d("--->", "CompaniesViewModel [onCleared]: Start")
        super.onCleared()
    }

    fun getAllCompanies() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val allCompaniesList = getAllCompaniesUseCase.execute()
                liveAllCompaniesList.postValue(allCompaniesList)
                Log.d("--->", "CompaniesViewModel [getAllCompanies]: $allCompaniesList")
            } catch (e: SocketTimeoutException) {
                liveToast.postValue(e.message)
                Log.e("--->", "CompaniesViewModel [getAllCompanies]: Timeout Exception: ${e.message}")
            } catch (e: Exception) {
                liveToast.postValue(e.message)
                Log.e("--->", "CompaniesViewModel [getAllCompanies]: Exception: ${e.message}")
            }
        }
    }

}