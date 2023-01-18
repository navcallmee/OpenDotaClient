package com.example.killreal.ui.teams

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide;
import com.example.killreal.data.teams.TeamsListItem
import com.example.killreal.databinding.ItemTeamsListBinding
import com.example.killreal.ui.OnNavigateCallback

class TeamsListAdapter(val context: Context, val teamList: List<TeamsListItem>, val onNavigateCallback: OnNavigateCallback): RecyclerView.Adapter<TeamsListAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemTeamsListBinding):RecyclerView.ViewHolder(binding.root) {
        var iBTeamIcon = binding.iBTeamIcon
        var tVTeamLastMatchTime = binding.tVTeamLastMatchTime
        var tVTeamName = binding.tVTeamName
        var tVTeamLosses = binding.tVTeamLosses
        var tVTeamWins = binding.tVTeamWins
        var tVTeamRating = binding.tVTeamRating
        var root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTeamsListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.iBTeamIcon)
            .load(teamList[position].logoUrl)
            .into(holder.iBTeamIcon)
        holder.tVTeamLosses.text = teamList[position].losses.toString()
        holder.tVTeamName.text = teamList[position].name
        holder.tVTeamRating.text = teamList[position].rating.toString()
        holder.tVTeamWins.text = teamList[position].wins.toString()
        holder.tVTeamLastMatchTime.text = teamList[position].lastMatchTime.toString()

        holder.root.setOnClickListener(){
            onNavigateCallback.navigate(teamList[position])
        }
    }


    override fun getItemCount(): Int {
        return teamList.size
    }
}