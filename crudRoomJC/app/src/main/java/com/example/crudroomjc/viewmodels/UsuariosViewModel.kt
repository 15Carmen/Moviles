package com.example.crudroomjc.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudroomjc.models.Usuarios
import com.example.crudroomjc.room.UsuariosDatabaseDao
import com.example.crudroomjc.states.UsuariosState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Clase que
 */
class UsuariosViewModel(
    private val dao: UsuariosDatabaseDao
) : ViewModel(){

    //Variable con el estado
    var state by mutableStateOf(UsuariosState())

        //Indicamos que el estado va a tener el metodo set
        private set

    //Definimos el comportamiento cuando se inicialice el viewmodel
    init {
        viewModelScope.launch {
            dao.obtenerUsuarios().collectLatest {
                //Redibujamos los objetos que le mostramos al usuario
                state = state.copy(
                    listaUsuarios = it
                )
            }
        }
    }

    fun agregarUsuario(usuario:Usuarios) = viewModelScope.launch {
        dao.agregarUsuario(usuario = usuario)
    }

    fun actualizarUsuario(usuario:Usuarios) = viewModelScope.launch {
        dao.actualizarUsuario(usuario = usuario)
    }

    fun borrarUsuario(usuario: Usuarios) = viewModelScope.launch {
        dao.borrarUsuario(usuario = usuario)
    }

}