package com.example.killreal.data.heroes.cloud

import com.example.killreal.data.core.AbstractMapper
import com.example.killreal.data.heroes.HeroesData

abstract class HeroesResponseMapperToData :
    AbstractMapper<Map<String, HeroResponse>, List<HeroesData>>() {

    class Base : HeroesResponseMapperToData() {
        override fun map(data: Map<String, HeroResponse>) = data.map {
            HeroesData(
                it.value.id,
                it.value.agiGain,
                it.value.attackRange,
                it.value.attackRate,
                it.value.attackType,
                it.value.baseAgi,
                it.value.baseArmor,
                it.value.baseAttackMax,
                it.value.baseAttackMin,
                it.value.baseHealth,
                it.value.baseHealthRegen,
                it.value.baseInt,
                it.value.baseMana,
                it.value.baseManaRegen,
                it.value.baseMr,
                it.value.baseStr,
                it.value.cmEnabled,
                it.value.icon,
                it.value.img,
                it.value.intGain,
                it.value.legs,
                it.value.localizedName,
                it.value.moveSpeed,
                it.value.name,
                it.value.primaryAttr,
                it.value.projectileSpeed,
                it.value.roles,
                it.value.strGain,
                it.value.turnRate?: ""
            )
        }
    }
}