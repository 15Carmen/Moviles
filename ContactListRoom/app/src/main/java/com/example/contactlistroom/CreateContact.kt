package com.example.contactlistroom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.contactlistroom.databinding.CreateContactBinding
import com.example.contactlistroom.entidades.ContactsEntity
import kotlinx.coroutines.runBlocking

class CreateContact : AppCompatActivity(){

    /*
    private lateinit var binding: CreateContactBinding

    val viewModel : ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = CreateContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener{
            runBlocking { createContact(it) }
        }
    }

     suspend fun createContact(it: View?){

        val nombre = binding.etName.text.toString()
        val tlf = binding.etNumber.text.toString()

        val data = ContactsEntity(null, nombre = nombre, tlf = tlf)

        viewModel.addContacts(data)

        Toast.makeText(this@CreateContact, "Contacto guardado", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@CreateContact, MainActivity::class.java))
    }
*/
}