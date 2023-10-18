package com.example.galeria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.galeria.databinding.ActivityGaleriaBinding


class MainActivity : ComponentActivity() {

    private val COLUMNAS = 3
    val galeriaAdapter : FotosAdapter = FotosAdapter()
    val fotosList = ArrayList<Fotos>()

    lateinit var binding : ActivityGaleriaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGaleriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargarImagenes()
    }

    private fun cargarImagenes() {
        galeriaAdapter.AdaptadorFotos(fotosList, this)
        binding.recycleView.layoutManager = GridLayoutManager(this, COLUMNAS)
        binding.recycleView.adapter = galeriaAdapter
        galeriaAdapter.notifyDataSetChanged()

        fotosList.add(Fotos("https://loremflickr.com/320/240?random=1"))
        fotosList.add(Fotos("https://loremflickr.com/320/240?random=2"))
        fotosList.add(Fotos("https://loremflickr.com/320/240?random=3"))
        fotosList.add(Fotos("https://loremflickr.com/320/240?random=4"))
        fotosList.add(Fotos("https://loremflickr.com/320/240?random=5"))
        fotosList.add(Fotos("https://loremflickr.com/320/240?random=6"))
        fotosList.add(Fotos("https://loremflickr.com/320/240?random=7"))
        galeriaAdapter.notifyDataSetChanged()

    }
}

