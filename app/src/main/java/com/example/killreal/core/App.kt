package com.example.killreal.core

import android.app.Application
import com.example.killreal.data.core.CacheDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        cacheDatabase = CacheDatabase.getDatabase(this)
    }

    companion object {
        lateinit var cacheDatabase: CacheDatabase
    }
}