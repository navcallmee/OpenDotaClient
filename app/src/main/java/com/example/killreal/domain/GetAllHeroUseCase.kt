package com.example.killreal.domain

import com.example.killreal.data.heroes.HeroesRepository
import com.example.killreal.ui.heroes.adapter.Hero

interface GetAllHeroUseCase {

    suspend fun getAllUseCase(): List<Hero>

    class Base(
        private val heroesRepository: HeroesRepository
    ) : GetAllHeroUseCase {
        override suspend fun getAllUseCase() = heroesRepository.getHeroes().map {
            Hero("https://api.opendota.com${it.img}")
        }
    }
}