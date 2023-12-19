package com.example.whatssappfirebase.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.whatssappfirebase.R
import com.google.firebase.Firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class LoginActivity : AppCompatActivity() {

    private lateinit var etLoginEmail: EditText
    private lateinit var etLoginPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnGoSignUp: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Inicializamos la autenticación de firebase
        auth = Firebase.auth

        //Inicializamos los elementos del layout
        etLoginEmail = findViewById(R.id.etLoginEmail)
        etLoginPassword = findViewById(R.id.etLoginPassword)

        btnLogin = findViewById(R.id.btnLogin)
        btnGoSignUp = findViewById(R.id.btnGoSignUp)

        //Indicamos que hacen los botones

        //si el usuario pulsa el boton login
        btnLogin.setOnClickListener{

            //Guardamos en una variable lo que el usuario haya introducido por parámetros
            val email = etLoginEmail.text.toString()
            val password = etLoginPassword.text.toString()

            //Si las varaibles no estan vacias
            if (checkEmpy(email, password)){
                //Llamamos al metodo login
               login(email, password)
            }
        }

        //Si el usuario pulsa el botn sign up
        btnGoSignUp.setOnClickListener {
            //redirigimos la vista del usuario a la actividad de registro
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }

    /**
     * Función que comprueba que el usuario y la contraseña del usurio se encuentran en la base de datos
     */
    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener (this){
                    task ->
                //Si encuentra un usuario con ese email y contraseña se redirige la pantalla a la actividad de chat
                if (task.isSuccessful){
                    startActivity(Intent(this, UsersActivity::class.java))
                    finish()
                }else{ //Si no encuentra ningún usuario muestra un toast indicando que el login falló
                    Toast.makeText(applicationContext, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
    }

    /**
     * Función que devuelve false si alguno de los parámetros introducidos se encuentra vacío y true si
     * ambos parámetros no lo están
     */
    private fun checkEmpy(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }
}