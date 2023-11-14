package com.example.contactlistroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlistroom.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    // private variable to inflate the layout for the activity
    private lateinit var binding: ActivityMainBinding

    // variable to access the ViewModel class
    val viewModel : ContactViewModel  by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inflate the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set onClickListener for the floating action button
        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this , CreateContact::class.java)
            startActivity(intent)
        }

        viewModel.getAllContacts().observe(this , Observer {  listaContactos->
            // set the layout manager and the adapter for the recycler view
            binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            binding.recyclerView.adapter = ContactsAdapter(this,listaContactos)
        })



    }

}

