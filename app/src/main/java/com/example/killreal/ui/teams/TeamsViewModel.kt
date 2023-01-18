package com.example.killreal.ui.teams

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.killreal.DotaApi
import com.example.killreal.data.dataClassesResponse.TeamsListItem
import com.example.killreal.room.AppDatabase
import kotlinx.coroutines.*
import java.security.AccessController.getContext

class TeamsViewModel:ViewModel() {
    val teamsList = MutableLiveData<List<TeamsListItem>>()

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
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

    fun getTeam() = viewModelScope.safeLaunch(){
        val db = Room.databaseBuilder(
            ,
            AppDatabase::class.java, "teams"
        ).build()
        val response = DotaApi.getInstance().getTeamsList()
        teamsList.postValue(response.body()!!.toList())
    }
}