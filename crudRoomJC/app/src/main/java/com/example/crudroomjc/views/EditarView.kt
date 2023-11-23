package com.example.crudroomjc.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crudroomjc.models.Usuarios
import com.example.crudroomjc.viewmodels.UsuariosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarView(
    navController: NavController,
    viewModel: UsuariosViewModel,
    id: Int,
    usuario: String?,
    email: String?
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Editar View", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        })
                    {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {

        ContentEditarView(it, navController, viewModel, id, usuario, email)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentEditarView(
    it: PaddingValues,
    navController: NavController,
    viewModel: UsuariosViewModel,
    id: Int,
    usuario: String?,
    email: String?
) {
    var usuario by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = usuario ?: "", //Cuando no introduzca nada que quede un string vacio
            onValueChange = { usuario = it },
            label = { Text(text = "usuario") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = email ?: "", //Cuando no se introduzca nada que quede un string vacio
            onValueChange = { email = it },
            label = { Text(text = "email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        Button(
            onClick = {
                //Nos creamos un objeto usuario con los datos introducidos anteriormente
                val usuario = Usuarios(id = id, usuario = usuario!!, email = email!!) //Indicamos que ni usuario ni email puedan ser nulos

                //Llamamos al metoso actualizar usuario y le pasamos el objeto usuario por parámetros
                viewModel.actualizarUsuario(usuario)
                //Indicamos que se salga de la vista cuando se pulse el boton
                navController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }

    }
}