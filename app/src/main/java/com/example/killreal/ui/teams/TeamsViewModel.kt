package com.example.killreal.ui.teams

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.killreal.DotaApi
import com.example.killreal.data.teams.TeamsListItem
import kotlinx.coroutines.*

class TeamsViewModel : ViewModel() {
    val teamsList = MutableLiveData<List<TeamsListItem>>()

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
    }

    fun CoroutineScope.safeLaunch(
        exceptionHandler: CoroutineExceptionHandler = coroutineExceptionHandler,
        launchBody: suspend () -> Unit
    ): Job {
        return this.launch(exceptionHandler) {
            withContext(Dispatchers.IO) {
                launchBody.invoke()
            }
        }
    }

    fun getTeam() = viewModelScope.safeLaunch() {
        val response = DotaApi.getInstance().getTeamsList()
        teamsList.postValue(response.body()!!.toList())
    }
}