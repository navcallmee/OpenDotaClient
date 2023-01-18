package com.example.killreal.ui.heroes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.killreal.databinding.FragmentHeroesBinding

class HeroesFragment : Fragment() {

    //recycler
    private val  viewModel = HeroesViewModel()

    //viewbinding
    lateinit var binding: FragmentHeroesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rVHeroes.layoutManager = GridLayoutManager(requireContext(), 3)

        viewModel.hero.observe(viewLifecycleOwner) {
            Log.d("qqqq", it.toString())
            binding.rVHeroes.adapter = HeroesListAdapter(requireContext(),it)
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