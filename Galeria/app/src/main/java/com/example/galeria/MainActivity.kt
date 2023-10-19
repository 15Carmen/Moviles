package com.example.galeria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.galeria.databinding.ActivityGaleriaBinding
import com.example.galeria.databinding.ItemFotosBinding


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fotosBinding = ActivityGaleriaBinding.inflate(layoutInflater)
        setContentView(fotosBinding.root)

        fotosBinding.vistaFoto.adapter = FotosAdapter(

            listOf(
                /*Fotos(""),
                Fotos(""),
                Fotos("")
                */
                Fotos("https://loremflickr.com/320/240?random=2"),
                Fotos("https://loremflickr.com/320/240?random=3"),
                Fotos("https://loremflickr.com/320/240?random=4"),
                Fotos("https://loremflickr.com/320/240?random=5"),
                Fotos("https://loremflickr.com/320/240?random=6"),
                Fotos("https://loremflickr.com/320/240?random=7"),
                Fotos("https://loremflickr.com/320/240?random=8"),
                Fotos("https://loremflickr.com/320/240?random=9"),
                Fotos("https://loremflickr.com/320/240?random=10"),
                Fotos("https://loremflickr.com/320/240?random=11"),
                Fotos("https://loremflickr.com/320/240?random=12"),
                Fotos("https://loremflickr.com/320/240?random=13"),
                Fotos("https://loremflickr.com/320/240?random=14"),

                )
            ,

            object : FotoPulsadaListener{
                override fun fotoPulsada(fotos: Fotos) {

                }
            }
        )

    }
}

