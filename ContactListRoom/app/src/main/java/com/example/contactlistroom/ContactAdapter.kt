package com.example.contactlistroom

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistroom.databinding.ItemContactBinding
import com.example.contactlistroom.entidades.ContactsEntity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.runBlocking

class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    var contactsList : MutableList<ContactsEntity> = ArrayList()
    lateinit var context : Context


    fun ContactsAdapter(contactsList: MutableList<ContactsEntity>, context: Context){
        this.contactsList = contactsList
        this.context = context
    }


    // Inner ViewHolder class
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val contactName = view.findViewById(R.id.contactName) as TextView
        val contactNumber = view.findViewById(R.id.contactNumber) as TextView
        val contactImage = view.findViewById(R.id.contactFoto) as ImageView

        fun bind(contactsEntity: ContactsEntity, context: Context){
            contactName.text = contactsEntity.nombre
            contactNumber.text = contactsEntity.tlf
            contactImage.loadUrl(contactsEntity.image)
        }

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = contactsList.get(position)
        holder.bind(contacto, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_contact, parent, false))
    }

    // function returns the number of items in the list
    override fun getItemCount(): Int {
        return contactsList.size
    }
}






