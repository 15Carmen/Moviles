package com.example.agendajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agendajetpackcompose.ui.theme.AgendaJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemList(
                itemContacto = listOf(
                    Contacto("Juan","616223457"),
                    Contacto("María","234567892"),
                    Contacto("Raúl","612345672"),
                    Contacto("Ana","623452345"),
                    Contacto("Isa","672381234"),

                    Contacto("Juan","616223457"),
                    Contacto("María","234567892"),
                    Contacto("Raúl","612345672"),
                    Contacto("Ana","623452345"),
                    Contacto("Isa","672381234"),

                    Contacto("Juan","616223457"),
                    Contacto("María","234567892"),
                    Contacto("Raúl","612345672"),
                    Contacto("Ana","623452345"),
                    Contacto("Isa","672381234"),
                )
            )
        }
    }

    @Composable
    fun ItemList(itemContacto: List<Contacto>){
        LazyColumn {    //Se produce una lista de desplazamiento vertical (un scroll)
            items(itemContacto) { itemContacto ->
                ContactoView(contacto = itemContacto)
            }
        }
    }

    @Composable
    fun ContactoView(contacto: Contacto){
        Card (Modifier.fillMaxWidth()){
            Row {
                Column {
                    Image(painter = painterResource(id = R.drawable.michi_gafas),
                        contentDescription = "Foto contacto",
                        Modifier.height(100.dp)
                    )
                }
                Column {
                    Text(text = contacto.nombre,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(text = contacto.tfno,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}




