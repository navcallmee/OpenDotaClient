package com.example.killreal

import com.example.killreal.data.players.ProPlayersListItem
import com.example.killreal.data.teams.TeamsListItem
import com.example.killreal.data.teams.TeamMatchesItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DotaApi {

    @GET ("proPlayers")
    suspend fun getProPlayersList(): Response<List<ProPlayersListItem>>

    @GET ("teams")
    suspend fun getTeamsList(): Response<List<TeamsListItem>>

    @GET ("teams/{team_id}/matches")
    suspend fun getTeamMatches(@Path("team_id") id:Int): Response<List<TeamMatchesItem>>

    companion object{
        val baseUrl = "https://api.opendota.com/api/"
        var dotaApi:DotaApi? = null

        fun getInstance(): DotaApi {
            dotaApi =  Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(DotaApi::class.java)
            return dotaApi!!
        }
    }
}