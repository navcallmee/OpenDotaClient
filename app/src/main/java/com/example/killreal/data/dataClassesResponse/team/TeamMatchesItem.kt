package com.example.killreal.data.dataClassesResponse.team

import com.google.gson.annotations.SerializedName

data class TeamMatchesItem(
    val cluster: Int,
    val duration: Int,
    @SerializedName("league_name")
    val leagueName: String,
    @SerializedName("leagueid")
    val leagueId: Int,
    @SerializedName("match_id")
    val matchId: Long,
    @SerializedName("opposing_team_id")
    val opposingTeamId: Int,
    @SerializedName("opposing_team_logo")
    val opposingTeamLogo: String,
    @SerializedName("opposing_team_name")
    val opposingTeamName: String,
    val radiant: Boolean,
    @SerializedName("radiant_win")
    val radiantWin: Boolean,
    @SerializedName("start_time")
    val startTime: Int
)