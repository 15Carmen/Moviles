package com.example.crudroomjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.crudroomjc.navigation.NavManager
import com.example.crudroomjc.room.UsuariosDatabase
import com.example.crudroomjc.ui.theme.CrudRoomJCTheme
import com.example.crudroomjc.viewmodels.UsuariosViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrudRoomJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Construimos la base de datos
                    val database = Room.databaseBuilder(this, UsuariosDatabase::class.java, "db_usuarios").build()

                    //Instanciamos el dao (data access object)
                    val dao = database.usuariosDao()

                    //Instanciamos el viewModel y le pasamos el dao por parámetros
                    val viewModel = UsuariosViewModel(dao)

                    //Llamamos al NavManager y le pasamos el vieModel por parámetros
                    NavManager(viewModel = viewModel)
                }
            }
        }
    }
}

