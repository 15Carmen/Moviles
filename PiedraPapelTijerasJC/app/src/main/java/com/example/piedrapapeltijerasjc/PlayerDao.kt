package com.example.piedrapapeltijerasjc

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.concurrent.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * from player_entity ")
    suspend fun getNicks(): MutableList<PlayerEntity>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPlayer(playerEntity: PlayerEntity): Long



}