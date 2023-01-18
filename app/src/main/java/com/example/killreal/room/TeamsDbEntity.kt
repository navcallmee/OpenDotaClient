package com.example.killreal.room

import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import com.example.killreal.data.dataClassesResponse.TeamsListItem


@Entity(
    tableName = "teams",
    indices = [
        Index("name", unique = true)
    ]
)

data class TeamsDbEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "last_match_time") val lastMatchTime: Int,
    @ColumnInfo(name = "logo_url") val logoUrl: String,
    val losses: Int,
    val name: String,
    val rating: Float,
    val tag: String,
    val wins: Int
){
    fun toTeamsListItem():TeamsListItem = TeamsListItem(
        lastMatchTime = lastMatchTime,
        logoUrl = logoUrl,
        losses = losses,
        name = name,
        rating = rating,
        tag = tag,
        wins = wins,
        teamId = id
    )
}



/*data class TeamsListItem(
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
)*/


