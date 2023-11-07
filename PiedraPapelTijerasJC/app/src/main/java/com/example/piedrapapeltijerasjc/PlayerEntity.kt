package com.example.piedrapapeltijerasjc

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "player_entity")
data class PlayerEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nickname: String = "",
    val partidasJugadas: Int = 0,
    val partidasGanadas: Int = 0
)
