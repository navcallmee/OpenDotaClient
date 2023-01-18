package com.example.killreal.ui.team

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.killreal.data.dataClassesResponse.team.TeamMatchesItem
import com.example.killreal.databinding.ItemTeamMatchesBinding
import com.google.gson.annotations.SerializedName

class TeamMatchesAdapter(val context: Context, val teamMatchesList: List<TeamMatchesItem>): RecyclerView.Adapter<TeamMatchesAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemTeamMatchesBinding):RecyclerView.ViewHolder(binding.root) {
        var matchId = binding.tVItemTeamMatchId
        var matchStartTime = binding.tVItemTeamMatchStartTime
        var leagueName = binding.tVItemTeamMatchLeagueName
        var matchDuration = binding.tVItemTeamMatchDuration
        var isRadiant = binding.tVItemTeamMatchRadiant
        var isRadiantWin = binding.tVItemTeamMatchRadiantWin
        var opposingTeamName = binding.tVItemTeamMatchOppName
        var opposingTeamLogo = binding.tVItemTeamMatchOppLogo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTeamMatchesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.matchDuration.text = teamMatchesList[position].duration.toString()
        holder.matchId.text = teamMatchesList[position].matchId.toString()
        holder.isRadiant.text = teamMatchesList[position].radiant.toString()
        holder.matchStartTime.text = teamMatchesList[position].startTime.toString()
        holder.isRadiantWin.text = teamMatchesList[position].radiantWin.toString()
        holder.leagueName.text = teamMatchesList[position].leagueName
        holder.opposingTeamName.text = teamMatchesList[position].opposingTeamName
        Glide.with(holder.opposingTeamLogo)
            .load(teamMatchesList[position].opposingTeamLogo)
            .into(holder.opposingTeamLogo)
    }

    override fun getItemCount(): Int {
        return teamMatchesList.size
    }
}