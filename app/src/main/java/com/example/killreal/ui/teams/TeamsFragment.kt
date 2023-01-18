package com.example.killreal.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.killreal.data.teams.TeamsListItem
import com.example.killreal.databinding.FragmentTeamsBinding
import com.example.killreal.ui.OnNavigateCallback


class TeamsFragment : Fragment() {

    //recycler
    private val  viewModel = TeamsViewModel()

    //viewBinding
    private lateinit var binding: FragmentTeamsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rVTeams.layoutManager = layoutManager

        viewModel.teamsList.observe(viewLifecycleOwner) {
            val adapter = TeamsListAdapter(requireContext(),it,object : OnNavigateCallback{
                override fun navigate(data: TeamsListItem) {
                    val action = TeamsFragmentDirections.actionTeamsFragmentToTeamFragment(
                        data.logoUrl,data.lastMatchTime,data.losses,data.name,
                        data.rating,data.tag,data.teamId,data.wins)
                    findNavController().navigate(action)
                }
            })
            binding.rVTeams.adapter = adapter
        }
        viewModel.getTeam()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamsBinding.inflate(inflater)
        return binding.root
    }
}