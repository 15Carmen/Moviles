package com.example.galeria

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galeria.databinding.ActivityGaleriaBinding
import com.example.galeria.databinding.ItemFotosBinding

class FotosAdapter (private val fotos: List<Fotos>, private val fotoPulsadaListener: FotoPulsadaListener): RecyclerView.Adapter<FotosAdapter.ViewHolder>(){

    class ViewHolder(val binding: ItemFotosBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(fotos: Fotos) {
            Glide
                .with(binding.root.context)
                .load(fotos.imagenMiniUrl)
                .into(binding.fotito);
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= ItemFotosBinding.inflate(LayoutInflater.from(parent.context),parent,false )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return fotos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fotos[position])

        holder.itemView.setOnClickListener{
            fotoPulsadaListener.fotoPulsada(fotos[position])
        }
    }

}