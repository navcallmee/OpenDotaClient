package com.example.killreal.data.heroes.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroesDao {

    @Query("SELECT * FROM heroes")
    suspend fun getAll(): List<HeroesTable>

    @Query("SELECT * FROM heroes WHERE name = :name")
    suspend fun getByName(name: String): HeroesTable?

    @Insert
    suspend fun insert(heroesTable: HeroesTable)
}