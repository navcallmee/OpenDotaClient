package com.example.killreal

import com.example.killreal.data.dataClassesResponse.HeroesListItem
import com.example.killreal.data.dataClassesResponse.ProPlayersListItem
import com.example.killreal.data.dataClassesResponse.TeamsListItem
import com.example.killreal.data.dataClassesResponse.team.TeamMatchesItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DotaApi {

    @GET ("constants/heroes")
    suspend fun getHeroesList(): Response<HashMap<String, HeroesListItem>>

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