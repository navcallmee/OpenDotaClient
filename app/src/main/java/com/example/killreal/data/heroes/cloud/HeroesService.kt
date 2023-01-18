package com.example.killreal.data.heroes.cloud

import retrofit2.Call
import retrofit2.http.GET

interface HeroesService {
    @GET("constants/heroes")
    fun getHeroesList(): Call<Map<String, HeroResponse>>
}