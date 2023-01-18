package com.example.killreal.ui.players.pro

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.killreal.databinding.FragmentPlayersProBinding

class ProPlayersFragment:Fragment() {

    //recycler
    private val  viewModel = ProPlayersViewModel()

    //viewbinding
    lateinit var binding: FragmentPlayersProBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rVProPlayers.layoutManager = layoutManager

        viewModel.proPlayer.observe(viewLifecycleOwner) {
            Log.d("qqqq", it.toString())
            binding.rVProPlayers.adapter = ProPlayersListAdapter(requireContext(),it)
        }
        viewModel.getProPlayers()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayersProBinding.inflate(inflater)
        return binding.root
    }
}