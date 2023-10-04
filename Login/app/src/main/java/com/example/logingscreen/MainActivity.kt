package com.example.logingscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.logingscreen.databinding.BienvenidaBinding
import com.example.logingscreen.databinding.LoginBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = LoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnAcceder.setOnClickListener {
            if(binding.campoUsuario.text.toString().isEmpty() || binding.campoContrasena.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this , Bienvenida::class.java)
                intent.putExtra("usuario", binding.campoUsuario.text.toString())
                startActivity(intent)
                Toast.makeText(applicationContext, "Iniciando sesión..." + binding.campoUsuario.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }


}