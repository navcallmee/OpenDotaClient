package com.example.killreal.data.heroes.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class HeroesTable(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "agi_gain") val agiGain: Double,
    @ColumnInfo(name = "attack_range")
    val attackRange: Int,
    @ColumnInfo(name = "attack_rate")
    val attackRate: Float,
    @ColumnInfo(name = "attack_type")
    val attackType: String,
    @ColumnInfo(name = "base_agi")
    val baseAgi: Float,
    @ColumnInfo(name = "base_armor")
    val baseArmor: Float,
    @ColumnInfo(name = "base_attack_max")
    val baseAttackMax: Float,
    @ColumnInfo(name = "base_attack_min")
    val baseAttackMin: Float,
    @ColumnInfo(name = "base_health")
    val baseHealth: Float,
    @ColumnInfo(name = "base_health_regen")
    val baseHealthRegen: Float,
    @ColumnInfo(name = "base_int")
    val baseInt: Float,
    @ColumnInfo(name = "base_mana")
    val baseMana: Float,
    @ColumnInfo(name = "base_mana_regen")
    val baseManaRegen: Float,
    @ColumnInfo(name = "base_mr")
    val baseMr: Float,
    @ColumnInfo(name = "base_str")
    val baseStr: Float,
    @ColumnInfo(name = "cm_enabled")
    val cmEnabled: Boolean,
    val icon: String,
    val img: String,
    @ColumnInfo(name = "int_gain")
    val intGain: Float,
    val legs: Int,
    @ColumnInfo(name = "localized_name")
    val localizedName: String,
    @ColumnInfo(name = "move_speed")
    val moveSpeed: Int,
    val name: String,
    @ColumnInfo(name = "primary_attr")
    val primaryAttr: String,
    @ColumnInfo(name = "projectile_speed")
    val projectileSpeed: Int,
    val roles: String,
    @ColumnInfo(name = "str_gain")
    val strGain: Double,
    @ColumnInfo(name = "turn_rate")
    val turnRate: String
)


