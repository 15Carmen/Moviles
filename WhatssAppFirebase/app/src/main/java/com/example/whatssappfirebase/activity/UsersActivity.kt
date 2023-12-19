package com.example.whatssappfirebase.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatssappfirebase.R
import com.example.whatssappfirebase.adapter.UserAdapter
import com.example.whatssappfirebase.models.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class UsersActivity : AppCompatActivity() {

    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter: UserAdapter

    private lateinit var auth: FirebaseAuth
    private lateinit var bd: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        auth = FirebaseAuth.getInstance()
        bd = FirebaseFirestore.getInstance()

        userList = ArrayList()
        adapter = UserAdapter(this, userList)

        userRecyclerView = findViewById(R.id.userRecyclerView)

        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.adapter = adapter

        loadUsers()
    }

    private fun loadUsers() {
        bd.collection("usuarios")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // Convertir el documento a un objeto User (ajusta según la estructura de tus documentos)
                    val user = document.toObject(User::class.java)
                    userList.add(user)
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                // Manejar errores de lectura desde Firestore
                Log.w("UsersActivity", "Error getting documents.", exception)
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.logOut) {
            auth.signOut()
            val intent = Intent(this@UsersActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()

            return true
        }
        return true
    }

}