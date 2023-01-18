package com.example.killreal.ui.team

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.killreal.databinding.FragmentTeamBinding

class TeamFragment() : Fragment() {

    //viewModel
    private var viewModel = TeamViewModel()

    //viewBinding
    lateinit var binding: FragmentTeamBinding

    private val args: TeamFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("111",args.logoUrl)
        Log.d("111",args.name)
        Log.d("111",args.wins.toString())
        Log.d("111",args.lastMatchTime.toString())
        Log.d("111",args.tag)
        Log.d("111",args.losses.toString())
        Log.d("111",args.rating.toString())
        Log.d("111",args.teamId.toString())

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rVFragmTeamMatches.layoutManager = layoutManager

        viewModel.teamMatchesList.observe(viewLifecycleOwner){
            Log.d("qqqq", it.toString())
            binding.rVFragmTeamMatches.adapter = TeamMatchesAdapter(requireContext(),it)
        }

        viewModel.getTeamMatches(args.teamId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamBinding.inflate(inflater)
        return binding.root
    }

}