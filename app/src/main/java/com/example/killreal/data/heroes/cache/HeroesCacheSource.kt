package com.example.killreal.data.heroes.cache

interface HeroesCacheSource {

    suspend fun getAll(): List<HeroesTable>

    suspend fun insert(heroes: List<HeroesTable>)

    class Base(private val heroesDao: HeroesDao) : HeroesCacheSource {
        override suspend fun getAll() = heroesDao.getAll()

        override suspend fun insert(heroes: List<HeroesTable>) {
            heroes.forEach {
                heroesDao.insert(it)
            }
        }
    }
}