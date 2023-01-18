package com.example.killreal.ui.heroes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.killreal.core.App
import com.example.killreal.data.core.Api
import com.example.killreal.data.heroes.HeroesDataMapperToCache
import com.example.killreal.data.heroes.HeroesRepository
import com.example.killreal.data.heroes.cache.HeroesCacheMapperToData
import com.example.killreal.data.heroes.cache.HeroesCacheSource
import com.example.killreal.data.heroes.cloud.HeroesCloudSource
import com.example.killreal.data.heroes.cloud.HeroesResponseMapperToData
import com.example.killreal.data.heroes.cloud.HeroesService
import com.example.killreal.databinding.FragmentHeroesBinding
import com.example.killreal.domain.GetAllHeroUseCase
import com.example.killreal.ui.heroes.adapter.HeroesListAdapter

class HeroesFragment : Fragment() {

    private val viewModel = HeroesViewModel(
        GetAllHeroUseCase.Base(
            HeroesRepository.Base(
                HeroesCloudSource.Base(
                    Api().makeService(HeroesService::class.java)
                ),
                HeroesCacheSource.Base(App.cacheDatabase.heroesDao),
                HeroesResponseMapperToData.Base(),
                HeroesDataMapperToCache.Base(),
                HeroesCacheMapperToData.Base()
            )
        )
    )

    //viewbinding
    lateinit var binding: FragmentHeroesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rVHeroes.layoutManager = GridLayoutManager(requireContext(), 3)

        viewModel.hero.observe(viewLifecycleOwner) {
            Log.d("qqqq", it.toString())
            binding.rVHeroes.adapter = HeroesListAdapter(requireContext(), it)
        }

        viewModel.getHero()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroesBinding.inflate(inflater)
        return binding.root
    }

}