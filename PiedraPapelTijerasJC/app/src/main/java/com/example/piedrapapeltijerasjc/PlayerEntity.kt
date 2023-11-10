package com.example.piedrapapeltijerasjc

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "player_entity")
data class PlayerEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var nickname: String = "",
    var partidasJugadas: Int = 0,
    var partidasGanadas: Int = 0
)
