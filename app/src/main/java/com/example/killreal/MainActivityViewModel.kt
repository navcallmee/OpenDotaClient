package com.example.killreal

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.killreal.data.heroesDataClasses.HeroesListItem
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityViewModel:ViewModel() {

    val hero = MutableLiveData<List<HeroesListItem>>()

    //errorCatcher
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
        val response = DotaApi.getInstanceqq().getData()
        hero.postValue(response.body()!!.toList().map { it.second })
    }
}