package com.example.contactlistroom.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactos")
data class ContactsEntity (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var nombre : String = "",
    var tlf : String = ""
)