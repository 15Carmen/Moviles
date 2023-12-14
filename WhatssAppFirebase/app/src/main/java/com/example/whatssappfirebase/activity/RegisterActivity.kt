package com.example.whatssappfirebase.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whatssappfirebase.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegisterActivity : AppCompatActivity() {

    private lateinit var etRegisterEmail: EditText
    private lateinit var etRegisterPassword: EditText
    private lateinit var etRegisterConfirmPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var btnGoLogin: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

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

    private fun checkEmpy(email: String, password: String, confirmPassword: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()
    }

    private fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener (this){
                task ->
                if (task.isSuccessful){
                    var intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(applicationContext, "Register failed!", Toast.LENGTH_SHORT).show()
                }
            }
    }
}