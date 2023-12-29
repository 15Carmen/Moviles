package com.example.whatssappfirebase.ui.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.whatssappfirebase.R
import com.example.whatssappfirebase.ui.core.Navigator
import com.example.whatssappfirebase.ui.core.showToast
import com.example.whatssappfirebase.ui.viewmodels.LoginUiState
import com.example.whatssappfirebase.ui.viewmodels.LoginViewModel


class LoginActivity : AppCompatActivity() {

    private lateinit var etLoginEmail: EditText
    private lateinit var etLoginPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnGoSignUp: Button

    private val mViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //Inicializamos los elementos del layout
        etLoginEmail = findViewById(R.id.etLoginEmail)
        etLoginPassword = findViewById(R.id.etLoginPassword)

        btnLogin = findViewById(R.id.btnLogin)
        btnGoSignUp = findViewById(R.id.btnGoSignUp)

        //Indicamos que hacen los botones

        //si el usuario pulsa el boton login
        btnLogin.setOnClickListener {

            //Guardamos en una variable lo que el usuario haya introducido por parámetros
            val email = etLoginEmail.text.toString()
            val password = etLoginPassword.text.toString()

            mViewModel.onLoginButtonPressed(email, password)
        }

        //Si el usuario pulsa el botn sign up
        btnGoSignUp.setOnClickListener {
            //redirigimos la vista del usuario a la actividad de registro
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        observeViewModel()
    }

    private fun observeViewModel(){
        mViewModel.uiState.observe(this){ uiState ->
            when(uiState){
                LoginUiState.ErrorOccurredState -> onErrorOccurred()
                LoginUiState.InvalidDataState -> onInvalidDataState()
                LoginUiState.LoginSuccessfullyState -> onLoginSuccessfully()
            }

        }
    }

    private fun onLoginSuccessfully() {
        Navigator.navigateToUsersListFrom(this)
    }

    private fun onErrorOccurred() {
        showToast(R.string.login_error_occurred)
    }

    private fun onInvalidDataState() {
        showToast(R.string.login_invalid_data)
    }


}