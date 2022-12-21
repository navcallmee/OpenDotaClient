package com.example.killreal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.killreal.databinding.ActivityMainBinding
import com.example.killreal.viewModels.HeroesViewModel

class MainActivity : AppCompatActivity() {

    private val  viewModel = HeroesViewModel()

    //recycler
    lateinit var myAdapter: MyAdapter
    lateinit var gridLayoutManager: LinearLayoutManager

    //viewbinding
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.recyclerviewUsers.layoutManager = gridLayoutManager

        viewModel.hero.observe(this) {
            binding.recyclerviewUsers.adapter = MyAdapter(baseContext,it)
        }*/
        

    }
}