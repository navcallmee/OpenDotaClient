package com.example.killreal.data.heroes

data class HeroesData(
    val id: Int,
    val agiGain: Double,
    val attackRange: Int,
    val attackRate: Float,
    val attackType: String,
    val baseAgi: Float,
    val baseArmor: Float,
    val baseAttackMax: Float,
    val baseAttackMin: Float,
    val baseHealth: Float,
    val baseHealthRegen: Float,
    val baseInt: Float,
    val baseMana: Float,
    val baseManaRegen: Float,
    val baseMr: Float,
    val baseStr: Float,
    val cmEnabled: Boolean,
    val icon: String,
    val img: String,
    val intGain: Float,
    val legs: Int,
    val localizedName: String,
    val moveSpeed: Int,
    val name: String,
    val primaryAttr: String,
    val projectileSpeed: Int,
    val roles: List<String>,
    val strGain: Double,
    val turnRate: String
)