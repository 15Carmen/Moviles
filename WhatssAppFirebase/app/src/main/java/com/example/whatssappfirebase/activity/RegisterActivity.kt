package com.example.whatssappfirebase.activity

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whatssappfirebase.R
import com.example.whatssappfirebase.models.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class RegisterActivity : AppCompatActivity() {

    private lateinit var etRegisterEmail: EditText
    private lateinit var etRegisterPassword: EditText
    private lateinit var etRegisterConfirmPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var btnGoLogin: Button

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    //private lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        db = Firebase.firestore

        etRegisterEmail = findViewById(R.id.etRegisterEmail)
        etRegisterPassword = findViewById(R.id.etRegisterPassword)
        etRegisterConfirmPassword = findViewById(R.id.etRegisterConfirmPassword)

        btnSignUp = findViewById(R.id.btnSignUp)
        btnGoLogin = findViewById(R.id.btnGoLogin)

        btnSignUp.setOnClickListener{
            val email = etRegisterEmail.text.toString()
            val password = etRegisterPassword.text.toString()
            val confirmPassword = etRegisterConfirmPassword.text.toString()

            if (password.equals(confirmPassword) && checkEmpy(email, password, confirmPassword)){
                register(email, password)
            }else{
                Toast.makeText(applicationContext, "Passwords don't match", Toast.LENGTH_SHORT).show()

            }
        }

        btnGoLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish() //ponemos un finish para no ocupar memoria
        }

    }

    /**
     * Función que devuelve false si alguno de los parámetros introducidos se encuentra vacío y true si
     * ambos parámetros no lo están
     */
    private fun checkEmpy(email: String, password: String, confirmPassword: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()
    }

    /**
     * Función que añade el usuario y la contraseña del usurio a la base de datos
     */
    private fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener (this){
                task ->
                //Si el usuario se añade a la bbdd con exito se redirige la pantalla a la actividad de users
                if (task.isSuccessful){
                    addUserToDatabase(auth.currentUser?.uid!!, email)
                    val intent = Intent(this, UsersActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{ //Si no se añade con exito, muestra un toast indicando que el registro falló
                    Toast.makeText(applicationContext, "Register failed!", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addUserToDatabase(uid: String, email: String) {

        try {
            val newUser = hashMapOf(
                "id" to uid,
                "nombre" to email,
                "fotoPerfilUrl" to null
            )

            db.collection("usuarios")
                .add(newUser)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }catch (e:Exception){
            Toast.makeText(applicationContext, "Error al introducir el usuario en la BBDD", Toast.LENGTH_SHORT).show()
        }

    }
}