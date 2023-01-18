package com.example.killreal.ui.heroes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide;
import com.example.killreal.R

class HeroesListAdapter(
    val context: Context, val heroes: List<Hero>
) : RecyclerView.Adapter<HeroesListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iVNewHeroIcon: ImageView = itemView.findViewById(R.id.iVNewHeroIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_hero_avatars, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.iVNewHeroIcon)
            .load(heroes[position].photo)
            .into(holder.iVNewHeroIcon)
    }
    //"https://api.opendota.com${heroes[position].photo}"

    override fun getItemCount() = heroes.size
}