package com.example.killreal.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.killreal.databinding.ActivityMainBinding
import com.example.killreal.ui.heroes.HeroesListAdapter
import com.example.killreal.ui.heroes.HeroesViewModel

class MainActivity : AppCompatActivity() {

    private val  viewModel = HeroesViewModel()

    //recycler
    lateinit var heroesListAdapter: HeroesListAdapter
    lateinit var gridLayoutManager: LinearLayoutManager

    //viewbinding
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}