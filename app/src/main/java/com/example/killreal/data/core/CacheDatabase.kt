package com.example.killreal.data.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.killreal.data.heroes.cache.HeroesDao
import com.example.killreal.data.heroes.cache.HeroesTable

@Database(
    version = 1,
    entities = [
        HeroesTable::class
    ]
)
abstract class CacheDatabase : RoomDatabase() {

    abstract val heroesDao: HeroesDao

    companion object {
        fun getDatabase(context: Context): CacheDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                CacheDatabase::class.java,
                "cache_database"
            ).fallbackToDestructiveMigration().build()
        }
    }
}