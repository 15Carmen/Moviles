package com.example.logingscreen

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.logingscreen.databinding.BienvenidaBinding
import com.example.logingscreen.databinding.LoginBinding

class Bienvenida : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bienvenida)
    }

    override fun onPause() {
        Log.i("actividad", "pausen")
        val binding = BienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.visibility = View.VISIBLE
        super.onPause()
    }

    override fun onResume() {
        val usuario = intent.getStringExtra("usuario").toString()
        Log.i("actividad", "$usuario")
        val binding = BienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textoBienvenida.text = "¡Bienvenido $usuario!"
        binding.imageView.visibility = View.INVISIBLE
        Toast.makeText(applicationContext, "Bienvenido de vuelta, $usuario", Toast.LENGTH_SHORT).show()
        super.onResume()
    }

}