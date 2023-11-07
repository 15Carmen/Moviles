package com.example.piedrapapeltijerasjc

import androidx.room.Dao
import androidx.room.Query
import java.util.concurrent.Flow

@Dao
interface PlayerDao {
    @Query("SELECT partidasJugadas - partidasGanadas from player_entity")
    fun difJugadasGanadas(partidasJugadas:Int, partidasGanadas: Int) : PlayerEntity

    @Query("SELECT nickname, partidasGanadas from player_entity Order by partidasGanadas")
    suspend fun getNicks(): MutableList<PlayerEntity>



}