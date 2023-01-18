package com.example.killreal.data.heroes

import com.example.killreal.data.core.AbstractMapper
import com.example.killreal.data.heroes.cache.HeroesTable

abstract class HeroesDataMapperToCache : AbstractMapper<List<HeroesData>, List<HeroesTable>>() {

    class Base : HeroesDataMapperToCache() {
        override fun map(data: List<HeroesData>) = data.map {
            HeroesTable(
                it.id.toLong(),
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
                it.roles.joinToString("/"),
                it.strGain,
                it.turnRate
            )
        }
    }
}
