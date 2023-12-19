package com.example.whatssappfirebase.activity

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatssappfirebase.R
import com.example.whatssappfirebase.adapter.MessageAdapter
import com.example.whatssappfirebase.models.Message
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.Exception

class ChatActivity : AppCompatActivity() {

    private lateinit var messageRecyclerView: RecyclerView
    private lateinit var messageBox: EditText
    private lateinit var sentButton: ImageView

    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageList: ArrayList<Message>
    private lateinit var bd: FirebaseFirestore

    var receiverRoom: String? = null
    var senderRoom: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val intent = Intent()
        val name = intent.getStringExtra("nombre")
        val receiverId = intent.getStringExtra("id")
        val senderId = FirebaseAuth.getInstance().currentUser?.uid

        senderRoom = receiverId + senderId
        receiverRoom = senderId + receiverId

        supportActionBar?.title = name

        bd = FirebaseFirestore.getInstance()

        messageRecyclerView = findViewById(R.id.chatRecyclerView)
        messageBox = findViewById(R.id.messageBox)
        sentButton = findViewById(R.id.sentButton)

        messageList = ArrayList()
        messageAdapter = MessageAdapter(this, messageList)

        messageRecyclerView.layoutManager = LinearLayoutManager(this)
        messageRecyclerView.adapter = messageAdapter

        //logic for adding data to recyclerView
        bd.collection("chats").document(senderRoom!!).collection("mensajes")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.e("ChatActivity", "Error getting messages", error)
                    return@addSnapshotListener
                }

                messageList.clear()

                if (snapshot != null) {
                    for (document in snapshot.documents) {
                        val message = document.toObject(Message::class.java)
                        if (message != null) {
                            messageList.add(message)
                        }
                    }
                }

                messageAdapter.notifyDataSetChanged()
            }


        //añadiendo los mensajes a la bbdd
        sentButton.setOnClickListener {

            val messageText = messageBox.text.toString()
            if (messageText.isNotEmpty()) {
                val messageObject = Message(senderId, messageText)

                bd.collection("chats").document(senderRoom!!).collection("mensajes")
                    .add(messageObject)
                    .addOnSuccessListener {
                        bd.collection("chats").document(receiverRoom!!).collection("mensajes")
                            .add(messageObject)
                    }
                    .addOnFailureListener { e ->
                        Log.e("ChatActivity", "Error adding message", e)
                    }

                messageBox.setText("")

            }

        }


    }
}
