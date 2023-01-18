package com.example.killreal.ui.players.pro

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide;
import com.example.killreal.R
import com.example.killreal.data.dataClassesResponse.ProPlayersListItem
import com.example.killreal.databinding.ItemPlayersProBinding
import com.example.killreal.databinding.ItemTeamsListBinding
import com.example.killreal.ui.teams.TeamsListAdapter

class ProPlayersListAdapter(val context: Context, val proPlayersList: List<ProPlayersListItem>): RecyclerView.Adapter<ProPlayersListAdapter.ViewHolder>() {

    class ViewHolder(binding:ItemPlayersProBinding):RecyclerView.ViewHolder(binding.root) {
        var iVNewHeroIcon: ImageView = itemView.findViewById(R.id.iVNewHeroIcon)

        /*var tVHeroName: TextView = itemView.findViewById(R.id.tVHeroName)
        var tVHeroRoles: TextView = itemView.findViewById(R.id.tVHeroRoles)
        var tVHeroPrimaryAttr: TextView = itemView.findViewById(R.id.tVHeroPrimaryAttr)
        var tVHeroAttackType: TextView = itemView.findViewById(R.id.tVHeroAttackType)
        var tVHeroLegs: TextView = itemView.findViewById(R.id.tVHeroLegs)*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ProPlayersListAdapter.ViewHolder(
            ItemPlayersProBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Glide.with(holder.iVNewHeroIcon).load("https://api.opendota.com${userList[position].img}").into(holder.iVNewHeroIcon)
        /*Glide.with(holder.iVHeroIcon).load("https://api.opendota.com${userList[position].img}").into(holder.iVHeroIcon)
        holder.tVHeroName.text = userList[position].localizedName
        holder.tVHeroRoles.text = userList[position].roles.toString()
        holder.tVHeroPrimaryAttr.text = userList[position].primaryAttr
        holder.tVHeroAttackType.text = userList[position].attackType
        holder.tVHeroLegs.text = userList[position].legs.toString()*/
    }

    override fun getItemCount(): Int {
        return proPlayersList.size
    }
}