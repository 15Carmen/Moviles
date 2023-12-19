package com.example.whatssappfirebase.models

import java.sql.Timestamp

data class Message (val idEmisor:String? = "", val texto:String? = "", val horaEnvio: Long = Timestamp(System.currentTimeMillis()).time)