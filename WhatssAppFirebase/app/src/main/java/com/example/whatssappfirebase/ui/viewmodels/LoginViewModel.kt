package com.example.whatssappfirebase.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whatssappfirebase.ui.core.isEmailValid
import com.example.whatssappfirebase.ui.core.isPasswordValid
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginViewModel : ViewModel(){

    //Inicializamos la autenticación de firebase
    private val auth by lazy { Firebase.auth }

    private val _uiState: MutableLiveData<LoginUiState> by lazy { MutableLiveData() }
    val uiState: LiveData<LoginUiState> = _uiState

    /**
     * Función que comprueba que el usuario y la contraseña del usurio se encuentran en la base de datos
     */
    fun onLoginButtonPressed(email: String, password: String) {

        if (password.isPasswordValid() && email.isEmailValid()) {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    onLoginSuccessfully()
                } else {
                    onErrorOcurred()
                }
            }
        } else {
            onInvalidData()
        }


    }

    private fun onLoginSuccessfully() {
        _uiState.postValue(LoginUiState.LoginSuccessfullyState)
    }

    private fun onErrorOcurred() {
        _uiState.postValue(LoginUiState.ErrorOccurredState)

    }

    private fun onInvalidData() {
        _uiState.postValue(LoginUiState.InvalidDataState)
    }


}

//Clase sellada, tiene una clase de subclases, que no puede esçxtendersse más alla de las clases hija que se definan aqui
sealed interface LoginUiState {
    data object LoginSuccessfullyState: LoginUiState
    data object ErrorOccurredState: LoginUiState
    data object InvalidDataState: LoginUiState
}

