package com.example.piedrapapeltijerasjc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.piedrapapeltijerasjc.ui.theme.PiedraPapelTijerasJCTheme
import com.example.piedrapapeltijerasjc.ui.theme.Purple80
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PiedraPapelTijerasJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ScreenNav()
                }
            }
        }
    }
}

/**
 * Función que utilizamos para poder navegar entre las diferentes pantallas
 */
@Composable
fun ScreenNav(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login_screen" ){

        composable("login_screen"){
            LoginScreen(navController = navController)
        }
        composable("game_screen"){
            GameScreen(navController = navController)
        }
    }
}


/**
 * Función que comprueba si el nickName introducido ya existe en la badat; y si no,
 * crea un nuevo  jugador.
 */
fun nuevoJugador (entity: PlayerEntity, dao: PlayerDao, nombre: String) {

    //runBlocking es una corrutina que separa la ejecución de la app
    //de la interacción con la base de datos

    runBlocking {
        //LLamamos a la tabla.
        val puntuaciones=dao.getNicks()

        var existe= false //Variable que comprueba si el nombre ya existe

        //Recorremos la tabla y si los nombres no coinciden, crea un usuario nuevo.
        for (puntuacion in puntuaciones) {
            if (puntuacion.nickname==entity.nickname) {
                existe=true
            }
        }

        //Creamos un usuario nuevo.
        if (!existe) {

            entity.nickname= nombre
            entity.partidasJugadas=1
            entity.partidasGanadas=0

            dao.addPlayer(entity)
        }else{
            entity.partidasJugadas++
        }
    }
}


/**
 * Función donde creamos el layout del login
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {

    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .background(Purple80),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.this_is_fine),
            contentDescription = "this is fine",
            Modifier.height(200.dp)
        )

        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            placeholder = { Text(text = "Nombre de usurio") },
            modifier = Modifier.padding(10.dp)
        )

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = { Text(text = "Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = {
                navController.navigate("game_screen")
            },
            colors = ButtonDefaults.buttonColors(Color(255, 165, 0, 255)),
            modifier = Modifier.padding(10.dp)

        ) {
            Text(text = "Log in")
        }


    }
}


/**
 * Función donde creamos el layout del juego de piedra, papel o tijeras y creamos las funciones
 * principales del mismo
 */
@Composable
fun GameScreen(modifier: Modifier = Modifier, navController: NavController) {

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


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple80),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Botones de la maquina
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Llamamos a la variable textoGanador para ajustar el texto final al ganador
            val textoGanador = textoGanador(puntosJugador, puntosMaquina)

            if (continuarPartida(puntosJugador, puntosMaquina)) {
                //Mostramos la puntuacion del jugador
                Text(
                    text = "Player score $puntosJugador" + "\n" +
                            "Computer score: $puntosMaquina",
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
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

                        //Switch que declarará quien gana el punto o si es empate muestra un
                        // mensaje indicandolo
                        when (ganador(eleccionJugador, eleccionMaquina)) {
                            0 -> Toast
                                .makeText(context, "Empate", Toast.LENGTH_SHORT)
                                .show()

                            1 -> puntosMaquina += 1 //Gana la máquina y le sumamos 1 a sus puntos
                            2 -> puntosJugador += 1 //Gana el jugador y le sumamos 1 a sus puntos
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

                        //Switch que declarará quien gana el punto o si es empate muestra un
                        // mensaje indicandolo
                        when (ganador(eleccionJugador, eleccionMaquina)) {
                            0 -> Toast
                                .makeText(context, "Empate", Toast.LENGTH_SHORT)
                                .show()

                            1 -> puntosMaquina += 1 //Gana la máquina y le sumamos 1 a sus puntos
                            2 -> puntosJugador += 1 //Gana el jugador y le sumamos 1 a sus puntos
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

                        //Switch que declarará quien gana el punto o si es empate muestra un
                        // mensaje indicandolo
                        when (ganador(eleccionJugador, eleccionMaquina)) {
                            0 -> Toast
                                .makeText(context, "Empate", Toast.LENGTH_SHORT)
                                .show()

                            1 -> puntosMaquina += 1 //Gana la máquina y le sumamos 1 a sus puntos
                            2 -> puntosJugador += 1 //Gana el jugador y le sumamos 1 a sus puntos
                        }
                    }
            )
        }
    }
}



/**
 *  Función que determina si se sigue juagndo la partida o no. Cuando la maquina o el jugador
 *  llegue a 5 se acabrá la partida
 */
fun continuarPartida(puntosJug: Int, puntosMaq: Int): Boolean {
    var siguenJugando = true
    //Si el jugador o la máquina llegan a 5 puntos
    if (puntosMaq >= 5 || puntosJug >= 5) {
        //Termina la partida
        siguenJugando = false
    }
    return siguenJugando
}



fun numeroRandom(): Int {
    return (1..3).random()
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

        //Todo: Hacer un update que añada un punto a partidas ganadas
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
        ScreenNav()
    }
}




