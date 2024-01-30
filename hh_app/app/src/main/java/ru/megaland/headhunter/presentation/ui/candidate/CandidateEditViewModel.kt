package ru.megaland.headhunter.presentation.ui.candidate

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.megaland.headhunter.domain.model.candidate.Candidate
import ru.megaland.headhunter.domain.usecase.GetCandidateByIdUseCase
import java.net.SocketTimeoutException

class CandidateEditViewModel(
    private val getCandidateByIdUseCase: GetCandidateByIdUseCase,
    ) : ViewModel() {
    var liveCandidateById = MutableLiveData<Candidate>()
    var liveToast = MutableLiveData<String>()

    init {
        Log.d("--->", "CandidateEditViewModel [init]: Start")
    }

    override fun onCleared() {
        Log.d("--->", "CandidateEditViewModel [onCleared]: Start")
        super.onCleared()
    }

    fun getCandidateById(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val candidateById = getCandidateByIdUseCase.execute(id)
                liveCandidateById.postValue(candidateById)
                Log.d("--->", "CandidateEditViewModel [getCandidate]: $candidateById")
            } catch (e: SocketTimeoutException) {
                liveToast.postValue(e.message)
                Log.e(
                    "--->",
                    "CandidateEditViewModel [getCandidate]: Timeout Exception: ${e.message}"
                )
            } catch (e: Exception) {
                liveToast.postValue(e.message)
                Log.e("--->", "CandidateEditViewModel [getAllCompanies]: Exception: ${e.message}")
            }
        }
    }


}