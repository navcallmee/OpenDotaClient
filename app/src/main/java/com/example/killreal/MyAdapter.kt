package com.example.killreal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.killreal.data.heroesDataClasses.HeroesListItem
import com.bumptech.glide.Glide;
import com.example.killreal.databinding.ActivityMainBinding
import com.example.killreal.databinding.RecyclerviewItemBinding

class MyAdapter(val context: Context, val userList: List<HeroesListItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var iVNewHeroIcon: ImageView = itemView.findViewById(R.id.iVNewHeroIcon)
        /*var tVHeroName: TextView = itemView.findViewById(R.id.tVHeroName)
        var tVHeroRoles: TextView = itemView.findViewById(R.id.tVHeroRoles)
        var tVHeroPrimaryAttr: TextView = itemView.findViewById(R.id.tVHeroPrimaryAttr)
        var tVHeroAttackType: TextView = itemView.findViewById(R.id.tVHeroAttackType)
        var tVHeroLegs: TextView = itemView.findViewById(R.id.tVHeroLegs)*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_hero_avatars,parent,false))
    }

    enum class Hero(val heroName: String){
        AntiMage("Anti-Mage"),
        Abaddon("Abaddon"),
        Axe("Axe")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*try {
            when(Hero.valueOf(userList[position].localizedName)) {
                Hero.AntiMage -> holder.iVHeroIcon.setImageResource(R.drawable.antimage)
                Hero.Abaddon -> holder.iVHeroIcon.setImageResource(R.drawable.abaddon)
                Hero.Axe -> holder.iVHeroIcon.setImageResource(R.drawable.axe)
            }
        }
        catch (e:java.lang.Exception){
            holder.iVHeroIcon.setImageResource(R.drawable.alchemist)
        }*/
        Glide.with(holder.iVNewHeroIcon).load("https://api.opendota.com${userList[position].img}").into(holder.iVNewHeroIcon)
        /*Glide.with(holder.iVHeroIcon).load("https://api.opendota.com${userList[position].img}").into(holder.iVHeroIcon)
        holder.tVHeroName.text = userList[position].localizedName
        holder.tVHeroRoles.text = userList[position].roles.toString()
        holder.tVHeroPrimaryAttr.text = userList[position].primaryAttr
        holder.tVHeroAttackType.text = userList[position].attackType
        holder.tVHeroLegs.text = userList[position].legs.toString()*/
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}