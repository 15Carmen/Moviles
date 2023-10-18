package com.example.galeria

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.galeria.databinding.ActivityGaleriaBinding
import com.example.galeria.databinding.ItemFotosBinding

class FotosAdapter : RecyclerView.Adapter<FotosAdapter.ViewHolder>(){

    var itemList: MutableList<Fotos> = ArrayList()
    var context : Context? = null

    class ViewHolder(val binding: ItemFotosBinding): RecyclerView.ViewHolder(binding.root)

    fun AdaptadorFotos(Imagen:MutableList<Fotos>, context: Context){
        this.itemList = Imagen
        this.context = context
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList?.get(position)

        Glide.with(context!!.applicationContext)
            .load(item?.imagenMiniUrl)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.binding.fotito)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFotosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return itemList!!.size
    }

}