package com.example.killreal.ui.heroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.killreal.domain.GetAllHeroUseCase
import com.example.killreal.ui.heroes.adapter.Hero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroesViewModel(
    private val getAllHeroUseCase: GetAllHeroUseCase
) : ViewModel() {

    val hero = MutableLiveData<List<Hero>>()

    fun getHero() = viewModelScope.launch(Dispatchers.IO) {
        hero.postValue(getAllHeroUseCase.getAllUseCase())
    }
}