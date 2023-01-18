package com.example.killreal.data.heroes

import android.util.Log
import com.example.killreal.data.heroes.cache.HeroesCacheMapperToData
import com.example.killreal.data.heroes.cache.HeroesCacheSource
import com.example.killreal.data.heroes.cloud.HeroesCloudSource
import com.example.killreal.data.heroes.cloud.HeroesResponseMapperToData

interface HeroesRepository {

    suspend fun getHeroes(): List<HeroesData>

    class Base(
        private val heroesCloudSource: HeroesCloudSource,
        private val heroesCacheSource: HeroesCacheSource,
        private val heroesResponseMapperToData: HeroesResponseMapperToData,
        private val heroesDataMapperToCache: HeroesDataMapperToCache,
        private val heroesCacheMapperToData: HeroesCacheMapperToData
    ) : HeroesRepository {

        override suspend fun getHeroes() = try {
            val data = heroesResponseMapperToData.map(heroesCloudSource.get())
            heroesCacheSource.insert(heroesDataMapperToCache.map(data))
            data
        } catch (e: Exception) {
            Log.d("SKdasdkasd", e.stackTraceToString())
            heroesCacheMapperToData.map(heroesCacheSource.getAll())
        }
    }
}