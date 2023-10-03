package com.example.logingscreen

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.logingscreen.databinding.LoginBinding
import com.example.logingscreen.databinding.WelcomeBinding


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginBinding = LoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        loginBinding.miBoton.text = "Pulsa aqui"

        loginBinding.miBoton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val toast = Toast.makeText(
                    applicationContext,
                    "¡Me has pulsado!",
                    Toast.LENGTH_SHORT
                ).show()

                val welcomeBinding = WelcomeBinding.inflate(layoutInflater)
                setContentView(welcomeBinding.root)
            }

        })


    }



}