package com.example.ejemplorv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplorv.databinding.ActivityMainBinding
import com.example.ejemplorv.databinding.ContactosBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contactos = ContactosBinding.inflate(layoutInflater)
        setContentView(contactos.root)

        contactos.vistaContactos.adapter = ContactosAdapter(
            listOf(
                Contacto("Juan", "616223457"),
                Contacto("María", "234567892"),
                Contacto("Raúl", "612345672"),
                Contacto("Ana", "623452345"),
                Contacto("Isa", "672381234"),

                Contacto("Carlos", "616223457"),
                Contacto("Alberto", "234567892"),
                Contacto("Lucia", "612345672"),
                Contacto("Anabel", "623452345"),
                Contacto("Luisa", "672381234"),

                Contacto("Juan Alberto", "616223457"),
                Contacto("María Magdalena", "234567892"),
                Contacto("Jesús", "612345672"),
                Contacto("José", "623452345"),
                Contacto("Pepe", "672381234"),

                Contacto("Paco", "616223457"),
                Contacto("Javi", "234567892"),
                Contacto("Pedro", "612345672"),
                Contacto("Carla", "623452345"),
                Contacto("Antonio", "672381234"),
            )
        )

    }
}