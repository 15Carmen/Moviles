package com.example.whatssappfirebase.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatssappfirebase.R
import com.example.whatssappfirebase.ui.views.ChatActivity
import com.example.whatssappfirebase.models.User

class UserAdapter(val context: Context, val userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentUser = userList[position]
        holder.txtEmail.text = currentUser.nombre
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)

            intent.putExtra("nombre", currentUser.nombre)
            intent.putExtra("id", currentUser.id)

            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val txtEmail: TextView = view.findViewById(R.id.itemEmail)
        val txtTemp: TextView = view.findViewById(R.id.itemTemp)


    }
}