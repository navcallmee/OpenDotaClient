package com.example.killreal.data.teams

import com.google.gson.annotations.SerializedName

data class TeamsListItem(
    @SerializedName("last_match_time")
    val lastMatchTime: Int,
    @SerializedName("logo_url")
    val logoUrl: String,
    val losses: Int,
    val name: String,
    val rating: Float,
    val tag: String,
    @SerializedName("team_id")
    val teamId: Int,
    val wins: Int
)