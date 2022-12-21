package com.example.killreal

import com.google.gson.annotations.SerializedName

data class RemoteDotaHero(
    @SerializedName("attack_type")
    val attackType: String,
    val id: Int,
    val legs: Int,
    @SerializedName("localized_name")
    val localizedName: String,
    val name: String,
    @SerializedName("primary_attr")
    val primaryAttr: String,
    val roles: List<String>
)