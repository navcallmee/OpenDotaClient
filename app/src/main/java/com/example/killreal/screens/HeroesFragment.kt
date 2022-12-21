package com.example.killreal.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.killreal.MainActivityViewModel
import com.example.killreal.MyAdapter
import com.example.killreal.R
import com.example.killreal.databinding.ActivityMainBinding
import com.example.killreal.databinding.FragmentHeroesBinding
import com.example.killreal.viewModels.HeroesViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class HeroesFragment : Fragment() {

    private val  viewModel = HeroesViewModel()
    //recycler
    lateinit var myAdapter: MyAdapter

    //viewbinding
    lateinit var binding: FragmentHeroesBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridLayoutManager = GridLayoutManager(requireContext(), 3)
        binding.heroesRecyclerView.layoutManager = gridLayoutManager

        viewModel.hero.observe(viewLifecycleOwner) {
            Log.d("qqqq", it.toString())
            binding.heroesRecyclerView.adapter = MyAdapter(requireContext(),it)
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