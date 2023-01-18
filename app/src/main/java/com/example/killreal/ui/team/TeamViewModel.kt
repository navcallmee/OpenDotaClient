package com.example.killreal.ui.team

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.killreal.DotaApi
import com.example.killreal.data.dataClassesResponse.team.TeamMatchesItem
import kotlinx.coroutines.*

class TeamViewModel : ViewModel() {

    val teamMatchesList = MutableLiveData<List<TeamMatchesItem>>()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
    }

    fun CoroutineScope.safeLaunch(
        exceptionHandler: CoroutineExceptionHandler = coroutineExceptionHandler,
        launchBody: suspend () -> Unit
    ): Job {
        return this.launch(exceptionHandler) {
            withContext(Dispatchers.IO){
                launchBody.invoke()
            }
        }
    }

    fun getTeamMatches(team_id:Int) = viewModelScope.safeLaunch(){
        val response = DotaApi.getInstance().getTeamMatches(team_id)
        teamMatchesList.postValue(response.body()!!.toList())
    }
}