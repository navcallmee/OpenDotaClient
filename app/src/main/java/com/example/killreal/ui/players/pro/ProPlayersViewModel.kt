package com.example.killreal.ui.players.pro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.killreal.DotaApi
import com.example.killreal.data.dataClassesResponse.ProPlayersListItem
import kotlinx.coroutines.*

class ProPlayersViewModel:ViewModel() {
    val proPlayer = MutableLiveData<List<ProPlayersListItem>>()

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

    fun getProPlayers() = viewModelScope.safeLaunch(){
        val response = DotaApi.getInstance().getProPlayersList()
        proPlayer.postValue(response.body()!!.toList())
    }
}