package com.example.contactlistroom

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistroom.databinding.ItemContactBinding
import com.example.contactlistroom.entidades.ContactsEntity

class ContactAdapter (
    val listaContactos : List<ContactsEntity>,  // Objeto Lista de contactos
    val context: Context
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){  //Devuelve la vista

    //Clase ViewHolder
    class ViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root){}

    //Instanciamos una variable Dao para poder interactuar con la base de datos
    private val dao = ContactDatabase.getDatabaseInstance(context).contactDao()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemContactBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.contactName.text = listaContactos[position].nombre
        holder.binding.contactNumber.text = listaContactos[position].tlf
        // delete button onClickListener to delete the
        // contact from the database and notify the
        // adapter of the change
        holder.binding.deleteButton.setOnClickListener{
            dao.deleteContact(listaContactos[position])
            notifyItemRemoved(position)
        }

        // itemView onClickListener to make a phone call
        // to the number of the contact
        holder.itemView.setOnClickListener{
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("" + listaContactos[position].tlf))
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listaContactos.size
    }




}