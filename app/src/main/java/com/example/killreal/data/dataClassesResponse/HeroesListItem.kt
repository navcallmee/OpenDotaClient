package com.example.killreal.data.dataClassesResponse

import com.google.gson.annotations.SerializedName

data class HeroesListItem(
    @SerializedName("agi_gain")
    val agiGain: Double,
    @SerializedName("attack_range")
    val attackRange: Int,
    @SerializedName("attack_rate")
    val attackRate: Float,
    @SerializedName("attack_type")
    val attackType: String,
    @SerializedName("base_agi")
    val baseAgi: Float,
    @SerializedName("base_armor")
    val baseArmor: Float,
    @SerializedName("base_attack_max")
    val baseAttackMax: Float,
    @SerializedName("base_attack_min")
    val baseAttackMin: Float,
    @SerializedName("base_health")
    val baseHealth: Float,
    @SerializedName("base_health_regen")
    val baseHealthRegen: Float,
    @SerializedName("base_int")
    val baseInt: Float,
    @SerializedName("base_mana")
    val baseMana: Float,
    @SerializedName("base_mana_regen")
    val baseManaRegen: Float,
    @SerializedName("base_mr")
    val baseMr: Float,
    @SerializedName("base_str")
    val baseStr: Float,
    @SerializedName("cm_enabled")
    val cmEnabled: Boolean,
    val icon: String,
    val id: Int,
    val img: String,
    @SerializedName("int_gain")
    val intGain: Float,
    val legs: Int,
    @SerializedName("localized_name")
    val localizedName: String,
    @SerializedName("move_speed")
    val moveSpeed: Int,
    val name: String,
    @SerializedName("primary_attr")
    val primaryAttr: String,
    @SerializedName("projectile_speed")
    val projectileSpeed: Int,
    val roles: List<String>,
    @SerializedName("str_gain")
    val strGain: Double,
    @SerializedName("turn_rate")
    val turnRate: String
)