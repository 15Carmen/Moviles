package com.example.whatssappfirebase.ui.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatssappfirebase.R
import com.example.whatssappfirebase.ui.adapter.MessageAdapter
import com.example.whatssappfirebase.models.Message
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.util.UUID

class ChatActivity : AppCompatActivity() {

    private lateinit var messageRecyclerView: RecyclerView
    private lateinit var messageBox: EditText
    private lateinit var sentButton: ImageView

    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageList: ArrayList<Message>

    var receiverRoom: String? = null
    var senderRoom: String? = null

    private val bd by lazy {  FirebaseFirestore.getInstance() }
    private val currentUserUid by lazy { FirebaseAuth.getInstance().currentUser?.uid }
    private var chatNameArg: String? = null
    private var chatReceiverId: String? = null
    private var chatRoomId: String? = null



    companion object {

        private const val CHAT_NAME_PARAM = "name"
        private const val CHAT_ID_PARAM = "id"
        private const val FIREBASE_CHAT_COLLECTION = "chats"
        private const val FIREBASE_MESSAGE_COLLECTION = "messages"

        @JvmStatic
        fun newInstance(context: Context, name: String, id: String) = Intent(context, ChatActivity::class.java).apply {
            putExtra(CHAT_NAME_PARAM, name)
            putExtra(CHAT_ID_PARAM, id)
        }
    }

    private fun onPrepareArguments() {
        with(intent) {
            chatNameArg = getStringExtra(CHAT_NAME_PARAM)
            chatReceiverId = getStringExtra(CHAT_ID_PARAM)
            senderRoom = chatReceiverId + currentUserUid
            receiverRoom = currentUserUid + chatReceiverId
        }
    }

    private fun onConfigureUI() {
        supportActionBar?.title = chatNameArg ?: "Chat Screen"
        messageRecyclerView = findViewById(R.id.chatRecyclerView)
        messageBox = findViewById(R.id.messageBox)
        sentButton = findViewById(R.id.sentButton)

        messageList = ArrayList()
        messageAdapter = MessageAdapter(this, messageList)

        messageRecyclerView.layoutManager = LinearLayoutManager(this)
        messageRecyclerView.adapter = messageAdapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        onPrepareArguments()
        onConfigureUI()

        if (currentUserUid == null) {
            finish()
        }



        //añadiendo los mensajes a la bbdd
        sentButton.setOnClickListener {

            val messageText = messageBox.text.toString()
            if (messageText.isNotEmpty()) {
                val messageObject = Message(currentUserUid, messageText)
                bd.collection("chats")
                    .document(senderRoom!!)
                    .collection("mensajes")
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

    private fun fillConversationMessage() {
        bd.collection(FIREBASE_CHAT_COLLECTION)
            .whereIn(FieldPath.documentId(), listOf(senderRoom, receiverRoom))
            .get()
            .addOnSuccessListener { documents ->
                documents.firstOrNull()?.id?.let { roomId ->
                    bd.collection(FIREBASE_CHAT_COLLECTION)
                        .document(roomId)
                        .collection(FIREBASE_MESSAGE_COLLECTION)
                        .orderBy("timestamp", Query.Direction.ASCENDING)
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
                }
            }
    }
}
