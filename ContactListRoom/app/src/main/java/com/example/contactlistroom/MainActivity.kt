package com.example.contactlistroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistroom.entidades.ContactsEntity

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView
    val mAdapter: ContactsAdapter = ContactsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpRecyclerView()

    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.ContactsAdapter(getSuperheros(), this)
        mRecyclerView.adapter = mAdapter
    }

    fun getSuperheros(): MutableList<ContactsEntity>{
        var contactosList:MutableList<ContactsEntity> = ArrayList()

        contactosList.add(ContactsEntity(1, "Marvel", "Peter Parker", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
        contactosList.add(ContactsEntity(2, "Marvel", "Matthew Michael Murdock", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
        contactosList.add(ContactsEntity(3, "Marvel", "James Howlett", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"))
        contactosList.add(ContactsEntity(4, "DC", "Bruce Wayne", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"))
        contactosList.add(ContactsEntity(5, "Marvel", "Thor Odinson", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"))

        return contactosList
    }

}

