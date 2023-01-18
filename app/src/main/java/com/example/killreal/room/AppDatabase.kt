package com.example.killreal.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        TeamsDbEntity::class
    ]
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getTeamsDao():TeamsDao
}