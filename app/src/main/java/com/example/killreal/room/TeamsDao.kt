package com.example.killreal.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamsDao {

    @Query("SELECT * FROM teams WHERE name = :name")
    suspend fun findByName(name:String):TeamsDbEntity?

    @Insert
    suspend fun addField(teamsDbEntity: TeamsDbEntity)

    @Query("SELECT * FROM teams WHERE id = :id")
    fun getById(id:Int):Flow<TeamsDbEntity?>
}