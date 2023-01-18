package com.example.killreal.data.players

import com.google.gson.annotations.SerializedName

data class ProPlayersListItem(
    @SerializedName("account_id")
    val accountId: Int,
    val avatar: String,
    @SerializedName("avatarfull")
    val avatarFull: String,
    @SerializedName("avatarmedium")
    val avatarMedium: String,
    val cheese: Int,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("fantasy_role")
    val fantasyRole: Int,
    @SerializedName("fh_unavailable")
    val fhUnavailable: Boolean,
    @SerializedName("full_history_time")
    val fullHistoryTime: String,
    @SerializedName("is_locked")
    val isLocked: Boolean,
    @SerializedName("is_pro")
    val isPro: Boolean,
    @SerializedName("last_login")
    val lastLogin: String?,
    @SerializedName("last_match_time")
    val lastMatchTime: String,
    @SerializedName("loccountrycode")
    val locCountryCode: String?,
    @SerializedName("locked_until")
    val lockedUntil: Int?,
    val name: String,
    @SerializedName("personaname")
    val personaName: String,
    val plus: Boolean,
    @SerializedName("profileurl")
    val profileUrl: String,
    @SerializedName("steamid")
    val steamId: String,
    @SerializedName("team_id")
    val teamId: Int,
    @SerializedName("team_name")
    val teamName: String?,
    @SerializedName("team_tag")
    val teamTag: String?
)