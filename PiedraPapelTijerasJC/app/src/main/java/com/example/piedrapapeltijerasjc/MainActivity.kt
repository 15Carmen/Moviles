package com.example.piedrapapeltijerasjc

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
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


fun numeroRandom(): Int {
    return (1..3).random()
}

/**
 * Función donde creamos el layout que vamos a mostrar por pantalla y creamos las funciones
 * principales del mismo
 */
@Composable
fun GameScreen(modifier: Modifier = Modifier) {

    //Creamos las variables donde guardaremos los puntos de los jugadores y las elecciones de
    //jugador y de la maquina
    var puntosJugador by remember { mutableStateOf(0) }
    var puntosMaquina by remember { mutableStateOf(0) }
    var eleccionMaquina by remember { mutableStateOf(R.drawable.neutral) }
    var eleccionJugador by remember { mutableStateOf(R.drawable.neutral) }

    //Hacemos un switch que cambie la imagen según lo que elija la máquina
    when (eleccionMaquina) {
        1 -> eleccionMaquina = R.drawable.piedra
        2 -> eleccionMaquina = R.drawable.papel
        3 -> eleccionMaquina = R.drawable.tijeras
    }

    //Hacemos otro switch para que cambie la imagen según lo que elija el jugador
    when (eleccionJugador) {
        1 -> eleccionJugador = R.drawable.piedra
        2 -> eleccionJugador = R.drawable.papel
        3 -> eleccionJugador = R.drawable.tijeras
    }

    //Creamos un contexto para el Toast de empate
    val context = LocalContext.current

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //Botones de la maquina
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = R.drawable.piedra),
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

            Image(
                painter = painterResource(id = eleccionMaquina),
                contentDescription = "Eleccion de la maquina",
                Modifier
                    .rotate(180F)
                    .size(150.dp)

            )

            //Puntos de los jugadores
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                //Llamamos a la variable textoGanador para ajustar el texto final al ganador
                val textoGanador = textoGanador(puntosJugador, puntosMaquina)

                if (continuarPartida(puntosJugador, puntosMaquina)) {
                    //Mostramos la puntuacion del jugador
                    Text(
                        text = "Player score: ${puntosJugador}",
                        fontSize = 30.sp
                    )
                    //Mostramos la puntuacion del ordenador
                    Text(
                        text = "Computer score: ${puntosMaquina}",
                        fontSize = 30.sp
                    )
                } else {
                    Text(
                        text = "Player score $puntosJugador" + "\n" +
                                "Computer score: $puntosMaquina" + "\n" +
                                "Ha ganado $textoGanador",
                        fontSize = 30.sp
                    )
                }


            }

            //eleccion jugador

            Image(
                painter = painterResource(
                    id = eleccionJugador
                ),
                contentDescription = "Eleccion del jugador",
                Modifier
                    .size(150.dp)
            )

            //Botones del jugador
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Image(painter = painterResource(id = R.drawable.piedra),
                    contentDescription = "piedra",
                    Modifier
                        .size(70.dp)
                        .clickable(enabled = continuarPartida(puntosJugador, puntosMaquina)) {
                            eleccionJugador = 1
                            eleccionMaquina =
                                numeroRandom() //La máquina elegirá un arma random entre 1 y 3

                            //Switch-case del ganador entre las armas escogidas
                            //Se llama a una función que determina el ganador y devuelve:
                            // 0 para empate, 1 para victoria jugador, 2 para victoria máquina
                            when (ganador(eleccionJugador, eleccionMaquina)) {
                                0 -> Toast
                                    .makeText(context, "Empate", Toast.LENGTH_SHORT)
                                    .show()

                                1 -> puntosMaquina++ //La maquina suma 1 punto
                                2 -> puntosJugador++ //El jugador suma 1 punto
                            }
                        }
                )

                Spacer(modifier = Modifier.width(50.dp))
                Image(
                    painter = painterResource(id = R.drawable.papel),
                    contentDescription = "papel",
                    Modifier
                        .size(70.dp)
                        .clickable(enabled = continuarPartida(puntosJugador, puntosMaquina)) {
                            eleccionJugador = 2
                            eleccionMaquina =
                                numeroRandom() //La máquina elegirá un arma random entre 1 y 3

                            //Switch-case del ganador entre las armas escogidas
                            //Se llama a una función que determina el ganador y devuelve:
                            // 0 para empate, 1 para victoria jugador, 2 para victoria máquina
                            when (ganador(eleccionJugador, eleccionMaquina)) {
                                0 -> Toast
                                    .makeText(context, "Empate", Toast.LENGTH_SHORT)
                                    .show()

                                1 -> puntosMaquina += 1 //La maquina suma 1 punto
                                2 -> puntosJugador += 1 //El jugador suma 1 punto
                            }
                        }
                )
                Spacer(modifier = Modifier.width(50.dp))
                Image(
                    painter = painterResource(id = R.drawable.tijeras),
                    contentDescription = "tijeras",
                    Modifier
                        .size(80.dp)
                        .rotate(270F)
                        .clickable(enabled = continuarPartida(puntosJugador, puntosMaquina)) {
                            eleccionJugador = 3
                            eleccionMaquina =
                                numeroRandom() //La máquina elegirá un arma random entre 1 y 3

                            //Switch-case del ganador entre las armas escogidas
                            //Se llama a una función que determina el ganador y devuelve:
                            // 0 para empate, 1 para victoria jugador, 2 para victoria máquina
                            when (ganador(eleccionJugador, eleccionMaquina)) {
                                0 -> Toast
                                    .makeText(context, "Empate", Toast.LENGTH_SHORT)
                                    .show()

                                1 -> puntosMaquina += 1 //La maquina suma 1 punto
                                2 -> puntosJugador += 1 //El jugador suma 1 punto
                            }
                        }
                )
            }
        }
    }




}

/**
 *  Función que determina si se sigue juagndo la partida o no. Cuando la maquina o el jugador
 *  llegue a 5 se acabrá la partida
 */
fun continuarPartida(puntosJug: Int, puntosMaq: Int): Boolean {
    var siguenJugando = true
    //Si el jugador o la máquina llegan a 3 puntos
    if (puntosMaq >= 5 || puntosJug >= 5) {
        //Termina la partida
        siguenJugando = false
    }
    return siguenJugando
}


/**
 * Función que recine por parámetros las elecciones tanto del jugador como de la máquina
 * y devuelve un entero en función del ganador resultante
 */
fun ganador(eleccionJug: Int, eleccionMaq: Int): Int {

    var ganador = 0 // Variable que guarda el ganador del duelo

    when (eleccionJug) { //switch case del arma del jugador
        1 ->//Cuando la eleccion del jugador sea 1 (piedra)
            //Hacemos un switch case según la eleccion de la máquina
            when (eleccionMaq) {
                1 -> ganador = 0 // Jugador = piedra, Máquina = Piedra, empate
                2 -> ganador = 1 // Jugador = piedra, Máquina = Papel, gana la máquina
                3 -> ganador = 2 // Jugador = piedra, Máquina = Tijeras, gana el jugador
            }

        2 ->//Cuando la elccion del jugador sea 2 (papel)
            //Hacemos un switch case según la eleccion de la máquina
            when (eleccionMaq) {
                1 -> ganador = 2 // Jugador = papel, Máquina = Piedra, gana el jugador
                2 -> ganador = 0 // Jugador = papel, Máquina = Papel, empate
                3 -> ganador = 1 // Jugador = papel, Máquina = Tijeras, gana la maquina
            }

        3 ->//Cuando la elccion del jugador sea 3 (tijeras)
            //Hacemos un switch case según la eleccion de la máquina
            when (eleccionMaq) {
                1 -> ganador = 1 // Jugador = tijeras, Máquina = Piedra, gana la máquina
                2 -> ganador = 2 // Jugador = tijeras, Máquina = Papel, gana el jugador
                3 -> ganador = 0 // Jugador = tijeras, Máquina = Tijeras, empate
            }
    }

    return ganador
}

/**
 * Función que recibe por parámetros las puntuaciones de ambos jugador y máquina, y devuelve
 * un string en función del que haya resultado vencedor
 */
fun textoGanador(puntosJug: Int, puntosMaq: Int): String {
    var texto = ""
    if (puntosJug > puntosMaq) {
        texto = "el jugador"
    } else {
        texto = "la máquina"
    }
    return texto
}

//Preview de la app

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    PiedraPapelTijerasJCTheme {
        GameScreen()
    }
}