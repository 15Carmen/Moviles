package com.example.logingscreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ControlActivity : AppCompatActivity(){



    val usuario = intent.getStringExtra("usuario")
    val password = intent.getStringExtra("password")
    var acceso = Intent(this, MainActivity::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(usuario == "Carmen" && password == "Marnu"){
            acceso = Intent(this, BienvenidaActivity::class.java)
        }


        startActivity(acceso)
        finish()

    }

}