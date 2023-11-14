package com.example.contactlistroom

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistroom.databinding.ItemContactBinding
import kotlinx.coroutines.runBlocking

class ContactsAdapter(
    val context: Context,
    val list: List<ContactsContract.Contacts>
) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    // Inner ViewHolder class
    class ViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {}

    // DAO instance to interact with the database
    private val dao = ContactDatabase.getDatabaseInstance(context).contactsDao()

    // function to inflate the layout for each contact and create a new ViewHolder instance
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    // function to bind the data to the view elements of the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.contactName.text = list[position].nombre
        holder.binding.contactNumber.text = list[position].tlf
        // delete button onClickListener to delete the
        // contact from the database and notify the
        // adapter of the change
        holder.binding.deleteButton.setOnClickListener {
            runBlocking {
                dao.deleteContact(list[position])
                notifyItemRemoved(position)
            }
        }

        // itemView onClickListener to make a phone call
        // to the number of the contact
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("" + list[position].tlf))
            context.startActivity(intent)
        }
    }

    // function returns the number of items in the list
    override fun getItemCount(): Int {
        return list.size
    }
}




