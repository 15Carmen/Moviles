package com.example.whatssappfirebase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatssappfirebase.R
import com.example.whatssappfirebase.models.User
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(private val context: Context, private val userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.txtEmail.text = user.email
        Glide.with(context).load(user.userImage).into(holder.imgUser)

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val txtEmail:TextView = view.findViewById(R.id.itemEmail)
        val txtTemp: TextView = view.findViewById(R.id.itemTemp)
        val imgUser: CircleImageView = view.findViewById(R.id.imgUser)
    }
}