package com.example.piedrapapeltijerasjc

import android.app.Application
import androidx.room.Room

class JuegoApp : Application() {

    companion object{
        lateinit var database: PlayerDatabase
    }

    override fun onCreate() {
        super.onCreate()
        JuegoApp.database = Room.databaseBuilder(this, PlayerDatabase::class.java, "players-db").build()
    }

}