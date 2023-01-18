package com.example.killreal.ui.heroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.killreal.DotaApi
import com.example.killreal.data.dataClassesResponse.HeroesListItem
import kotlinx.coroutines.*

class HeroesViewModel:ViewModel() {
    val hero = MutableLiveData<List<HeroesListItem>>()

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

    fun getHero() = viewModelScope.safeLaunch(){

        val response = DotaApi.getInstance().getHeroesList()
        hero.postValue(response.body()!!.toList().map { it.second })
    }
}