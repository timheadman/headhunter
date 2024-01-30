package ru.megaland.headhunter.presentation.ui.company

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.megaland.headhunter.domain.model.company.Company
import ru.megaland.headhunter.domain.usecase.GetCompanyByIdUseCase
import java.net.SocketTimeoutException

class CompanyDetailsViewModel(
    private val getCompanyByIdUseCase: GetCompanyByIdUseCase,
) : ViewModel() {
    val liveCompanyById = MutableLiveData<Company>()
    val liveToast = MutableLiveData<String>()

    init {
        Log.d("--->", "CompanyDetailsViewModel [init]: Start")
    }

    override fun onCleared() {
        Log.d("--->", "CompanyDetailsViewModel [onCleared]: Start")
        super.onCleared()
    }

    fun getCompanyById(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val companyById = getCompanyByIdUseCase.execute(id)
                liveCompanyById.postValue(companyById)
                Log.d("--->", "CompanyDetailsViewModel [getCompanyById]: $companyById")
            } catch (e: SocketTimeoutException) {
                liveToast.postValue(e.message)
                Log.e("--->", "CompanyDetailsViewModel [getCompanyById]: Timeout Exception: ${e.message}")
            } catch (e: Exception) {
                liveToast.postValue(e.message)
                Log.e("--->", "CompanyDetailsViewModel [getCompanyById]: Exception: ${e.message}")
            }
        }
    }

}