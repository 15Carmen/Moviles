package com.example.ejemplorv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ItemContactoBinding

class ContactosAdapter(private val contactos: List<Contacto>,
                       private val contactoPulsadoListener: ContactoPulsadoListener) :
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemContactoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(contacto: Contacto) {
            binding.nombre.text = contacto.nombre
            binding.telefono.text = contacto.tfno

            if(contacto.gender == "M"){
                binding.fotoContacto.setImageResource(R.drawable.male)
            }else{
                binding.fotoContacto.setImageResource(R.drawable.female)
            }
        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactos[position])

        holder.itemView.setOnClickListener{
            contactoPulsadoListener.contactoPulsado(contactos[position])
        }

        /* NO FUNCA :(
        holder.binding.fotoContacto.setOnClickListener{
            if (holder.binding.iniciales.isVisible){

                holder.binding.nombre.visibility = View.INVISIBLE
                holder.binding.telefono.visibility = View.INVISIBLE

            }else{

                holder.binding.nombre.visibility = View.VISIBLE
                holder.binding.telefono.visibility = View.VISIBLE
            }
        }*/

    }

}