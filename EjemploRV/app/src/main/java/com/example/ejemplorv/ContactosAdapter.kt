package com.example.ejemplorv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ItemContactoBinding

class ContactosAdapter(private val contactos: List<Contacto>) :
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemContactoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(contacto: Contacto) {
            ///...
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun getItemCount(): Int {
        return contactos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}