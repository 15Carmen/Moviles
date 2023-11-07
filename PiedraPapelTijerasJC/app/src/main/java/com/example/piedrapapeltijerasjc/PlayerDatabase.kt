package com.example.piedrapapeltijerasjc

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PlayerEntity::class), version = 1)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun taskDao():PlayerDao
}