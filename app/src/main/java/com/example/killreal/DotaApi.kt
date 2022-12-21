package com.example.killreal

import com.example.killreal.data.heroesDataClasses.HeroesListItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DotaApi {

    @GET ("/api/constants/heroes")
    suspend fun getData(): Response<HashMap<String, HeroesListItem>>

    companion object{
        val baseUrl = "https://api.opendota.com"
        var dotaApi:DotaApi? = null

        fun getInstanceqq(): DotaApi {
            dotaApi =  Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(DotaApi::class.java)
            return dotaApi!!
        }
    }
}