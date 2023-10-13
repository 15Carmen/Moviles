package com.example.ejemplorv

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import com.example.ejemplorv.databinding.ContactosBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contactos = ContactosBinding.inflate(layoutInflater)
        setContentView(contactos.root)

        contactos.vistaContactos.adapter = ContactosAdapter(
            listOf(
                Contacto("Juan", "JDC","616223457", "M"),
                Contacto("María", "MDLO","234567892", "F"),
                Contacto("Raúl", "RLA","612345672", "M"),
                Contacto("Ana", "APQ","623452345", "F"),
                Contacto("Isa", "ISK","672381234", "F"),

                Contacto("Jose", "JPC","616223457", "M"),
                Contacto("Marta", "MWE","234567892", "F"),
                Contacto("Raquel", "RLT","612345672", "F"),
                Contacto("Anabel", "ATO","623452345", "F"),
                Contacto("Isco", "ILH","672381234", "M"),

                Contacto("Jimena", "JCM","616223457", "F"),
                Contacto("Carla", "CGC","234567892", "F"),
                Contacto("Marcos", "MDG","612345672", "M"),
                Contacto("Lucia", "LMP","623452345", "F"),
                Contacto("Anthares", "ARP","672381234", "F"),

                Contacto("Antonio", "AMP","616223457", "M"),
                Contacto("Luisa", "LGG","234567892", "F"),
                Contacto("Paco", "FML","612345672", "M"),
                Contacto("Paquita", "PSM","623452345", "F"),
                Contacto("Lydia", "LPG","672381234", "F"),
            ),

            object :ContactoPulsadoListener{


                override fun contactoPulsado(contacto: Contacto) {
                    val dial = Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel: " + contacto.tfno)
                    )
                    startActivity(dial)
                }
            }

        )


    }
}