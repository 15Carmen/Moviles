package com.example.piedrapapeltijerasjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piedrapapeltijerasjc.ui.theme.PiedraPapelTijerasJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiedraPapelTijerasJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameScreen()
                }
            }
        }
    }
}




/**
 * Función donde creamos el layout que vamos a mostrar por pantalla y creamos las funciones
 * principales del mismo
 */
@Composable
fun GameScreen(modifier: Modifier = Modifier) {

    //Guardamos las variables donde guardaremos los puntos de los jugadores
    val puntosJugador = remember { mutableStateOf(0) }
    val puntosMaquina = remember { mutableStateOf(0) }
    var eleccionMaquina = remember { mutableStateOf("piedra") }
    var eleccionJugador = remember { mutableStateOf("piedra") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween) {

        //Botones de la maquina
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top) {
            Image(painter = painterResource(id = R.drawable.piedra),
                contentDescription = "piedra",
                Modifier
                    .size(70.dp)
                    .rotate(180F)
                    )

            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.papel),
                contentDescription = "papel",
                Modifier
                    .size(70.dp)
                    .rotate(180F)
            )
            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.tijeras),
                contentDescription = "tijeras",
                Modifier
                    .size(80.dp)
                    .rotate(90F)
            )
        }

        //eleccion maquina


        //Puntos de los jugadores
        Column (modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center){

            //Mostramos la puntuacion del jugador
            Text(text = "Player score: ${puntosJugador.value}",
                fontSize = 15.sp
            )
            //Mostramos la puntuacion del ordenador
            Text(text = "Computer score: ${puntosMaquina.value}",
                fontSize = 15.sp
            )
        }

        //eleccion jugador

        //Botones del jugador
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom) {
            Image(painter = painterResource(id = R.drawable.piedra),
                contentDescription = "piedra",
                Modifier
                    .size(70.dp)
                    .clickable {

                    })

            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.papel),
                contentDescription = "papel",
                Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.width(50.dp))
            Image(
                painter = painterResource(id = R.drawable.tijeras),
                contentDescription = "tijeras",
                Modifier
                    .size(80.dp)
                    .rotate(270F)
            )
        }
    }


}

fun movimientos(setMove: (String) -> Unit, eleccionMaquina: MutableState<String>, puntosJugador:MutableState<Int>, puntosMaquina:MutableState<Int>){

}


fun eleccionMaquina(movimientoMaquina: String){



}

//Preview de la app

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    PiedraPapelTijerasJCTheme {
        GameScreen()
    }
}