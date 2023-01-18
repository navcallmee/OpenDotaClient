package com.example.killreal.data.heroes.cloud

import com.example.killreal.data.core.ResponseCodeException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface HeroesCloudSource {

    suspend fun get(): Map<String, HeroResponse>

    class Base(private val service: HeroesService) : HeroesCloudSource {
        override suspend fun get() = withContext(Dispatchers.IO) {
            val response = service.getHeroesList().execute()
            if (response.code() == 200)
                return@withContext response.body()!!
            throw ResponseCodeException(response.code(), 200)
        }
    }
}