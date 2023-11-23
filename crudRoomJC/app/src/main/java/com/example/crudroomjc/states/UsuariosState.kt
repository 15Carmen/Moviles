package com.example.crudroomjc.states

import com.example.crudroomjc.models.Usuarios

/**
 * Clase que cuando la lista reciba alguna modificación automáticamente la va ha actualizar
 */
data class UsuariosState(
    val listaUsuarios: List<Usuarios> = emptyList()
)
