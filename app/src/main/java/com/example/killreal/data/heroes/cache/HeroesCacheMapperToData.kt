package com.example.killreal.data.heroes.cache

import com.example.killreal.data.core.AbstractMapper
import com.example.killreal.data.heroes.HeroesData

abstract class HeroesCacheMapperToData : AbstractMapper<List<HeroesTable>, List<HeroesData>>() {

    class Base : HeroesCacheMapperToData() {
        override fun map(data: List<HeroesTable>) = data.map {
            HeroesData(
                if (it.id > Int.MAX_VALUE) Int.MAX_VALUE else it.id.toInt(),
                it.agiGain,
                it.attackRange,
                it.attackRate,
                it.attackType,
                it.baseAgi,
                it.baseArmor,
                it.baseAttackMax,
                it.baseAttackMin,
                it.baseHealth,
                it.baseHealthRegen,
                it.baseInt,
                it.baseMana,
                it.baseManaRegen,
                it.baseMr,
                it.baseStr,
                it.cmEnabled,
                it.icon,
                it.img,
                it.intGain,
                it.legs,
                it.localizedName,
                it.moveSpeed,
                it.name,
                it.primaryAttr,
                it.projectileSpeed,
                it.roles.split("/"),
                it.strGain,
                it.turnRate
            )
        }
    }
}
