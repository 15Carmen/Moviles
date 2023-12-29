package com.example.whatssappfirebase.models

data class Message(val idEmisor: String?, val texto:String, val horaEnvio: Long = System.currentTimeMillis() )