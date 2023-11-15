package com.example.a7ymediafirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.a7ymediafirebase.databinding.ActivityJuegoBinding
import com.example.a7ymediafirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Creamos un binding para el login
        val bindingLogin = ActivityMainBinding.inflate(layoutInflater)
        //Creamos un binding de la pantalla del juego
        val bindingJuego = ActivityJuegoBinding.inflate(layoutInflater)

        //Mostramos la pantalla del login
        setContentView(bindingLogin.root)


        //Cuando se pulse el botón para empezar a jugar
        bindingLogin.btnComienzo.setOnClickListener {


            //Creamos las variables para guardar los nombres de los jugadores
            val jugador1 = findViewById<EditText>(R.id.jugador1Input).text.toString()
            val jugador2 = findViewById<EditText>(R.id.jugador2Input).text.toString()

            //Creamos las variables para guardar los puntos actuales de los jugadores
            var puntosActJug1 = 0.0
            var puntosActJug2 = 0.0


            //Si alguno de los campos de los nombres está vacio se lanza un mensaje de error
            if (jugador1.isEmpty() || jugador2.isEmpty()) {

                Toast.makeText(this,"Debes introducir el nombre de dos jugadores", Toast.LENGTH_SHORT ).show()
            } else {

                //mostramos la pantalla de juego
                setContentView(bindingJuego.root)

                //Mostramos que es el turno del jug1
                bindingJuego.turnoJug.text = "Turno de $jugador1"

                //Mostramos los puntos actuales de ambos jugadores
                bindingJuego.puntosJug1.text = "Puntos actuales de $jugador1: $puntosActJug1"
                bindingJuego.puntosJug2.text = "Puntos actuales de $jugador2: $puntosActJug2"

                //Desactivamos los botones del jugador 2, ya que aún no es su turno
                bindingJuego.btnUnaCartaJug2.isActivated = false
                bindingJuego.btnPlantarseJug2.isActivated = false

                //Cuando el jugador 1 pulse el botón para sacar una carta
                bindingJuego.btnUnaCartaJug1.setOnClickListener {

                    //Si los puntos del jugador 1 son menores a 7.5
                    if (puntosActJug1 <= 7.5){
                        //Se suma a la variable puntos los nuevos puntos que haya sacado el jugador
                        puntosActJug1 = sumaPuntos(puntosActJug1)

                        //Mostramos los puntos actuales del jugador1
                        bindingJuego.puntosJug1.text = "Puntos actuales de $jugador1: $puntosActJug1"

                        //Si los puntos del jugador 1 son mayores a 7.5
                        if (puntosActJug1 > 7.5){
                            //Mostramos un mensaje de que se ha pasado por pantalla
                            Toast.makeText(this, "Te has pasado!", Toast.LENGTH_SHORT).show()

                            //Desactivamos los botones del jugador 1
                            bindingJuego.btnUnaCartaJug1.isActivated = false
                            bindingJuego.btnPlantarseJug1.isActivated = false

                            //Activamos los botones del jugador 2
                            bindingJuego.btnUnaCartaJug2.isActivated = true
                            bindingJuego.btnPlantarseJug2.isActivated = true

                            //Se dice que es el turno del jug2
                            bindingJuego.turnoJug.text = "Turno de $jugador2"

                            //Se cambia la rotación del layout de los puntos
                            bindingJuego.linearLayout.rotation = 180f
                        }
                    }

                }

                //Si pulsa el boton para plantarse
                bindingJuego.btnPlantarseJug1.setOnClickListener {
                    //Desactivamos los botones del jugador 1
                    bindingJuego.btnUnaCartaJug1.isActivated = false
                    bindingJuego.btnPlantarseJug1.isActivated = false

                    //Activamos los botones del jugador 2
                    bindingJuego.btnUnaCartaJug2.isActivated = true
                    bindingJuego.btnPlantarseJug2.isActivated = true

                    //Se dice que es el turno del jug2
                    bindingJuego.turnoJug.text = "Turno de $jugador2"

                    //Se cambia la rotación del layout de los puntos
                    bindingJuego.linearLayout.rotation = 180f
                }

                //Cuando el jugador 2 pulse el boton para pedir una carta
                bindingJuego.btnUnaCartaJug2.setOnClickListener {

                    //Si los puntos del jugador 2 son menores a 7.5
                    if (puntosActJug2 <= 7.5){
                        //Se suma a la variable puntos los nuevos puntos que haya sacado el jugador
                        puntosActJug2 = sumaPuntos(puntosActJug2)

                        //Mostramos los puntos actuales del jugador1
                        bindingJuego.puntosJug2.text = "Puntos actuales de $jugador2: $puntosActJug2"

                        //Si los puntos del jugador 2 son mayores a 7.5
                        if (puntosActJug2 > 7.5){

                            //Mostramos un mensaje de que se ha pasado por pantalla
                            Toast.makeText(this, "Te has pasado!", Toast.LENGTH_SHORT).show()

                            //Desactivamos los botones del jugador 2
                            bindingJuego.btnUnaCartaJug2.isActivated = false
                            bindingJuego.btnPlantarseJug2.isActivated = false

                            //Guardamos el texto que indica quién ha ganado llamando a una función
                            val textoGanador = ganador(puntosActJug1, jugador1, puntosActJug2, jugador2)

                            //Mostramos quién ha ganado
                            bindingJuego.turnoJug.text = "$textoGanador"
                        }
                    }
                }

                //Cuando el jugador 2 pulsa el boton para plantarse
                bindingJuego.btnPlantarseJug2.setOnClickListener {

                    //Desactivamos los botones del jugador 2
                    bindingJuego.btnUnaCartaJug2.isActivated = false
                    bindingJuego.btnPlantarseJug2.isActivated = false

                    //Guardamos el texto que indica quién ha ganado llamando a una función
                    val textoGanador = ganador(puntosActJug1, jugador1, puntosActJug2, jugador2)

                    //Mostramos quién ha ganado
                    bindingJuego.turnoJug.text = "$textoGanador"

                }
            }
        }
    }

    /**
     * Función que recibe por parámetros los puntos que tiene actualmente el jugador y le suma a
     * estos un numero aleatorio del 1 al 7 o si el numero random es 8, 9 o 10, le suma 0.5
     * La función devuelve el resultado de la suma de los puntos
     */
    private fun sumaPuntos(puntosActuales: Double): Double {

        //Creamos una variable que guarde un numero random entre 1 y 10
        var numRandom = (1..10).random()
        //Creamos una variable que guarde la suma total de los puntos actuales del jugador más el numero random
        var total = puntosActuales

        //Si los puntos actuales son menores que 7.5
        if (total <= 7.5){
            //Si el numero random se encuentra entre 8 y 10
            if (numRandom in 8..10){
                //Le sumamos a los puntos actuales 0.5
                total += 0.5
            }else{  //Si no, le sumamos el numero random al total
                total += numRandom
            }
        }
        //Devolvemos la suma total
        return total
    }

    /**
     * Función que recibe por parámetros los puntos de ambos jugadores y los nombres de ambos, y declarara
     * el ganardor de la partida según las reglas del juego de las 7 y media.
     * Devuelve un string con el nombre del ganador o un mensaje de empate
     */
    private fun ganador(puntosJug1:Double, nombreJug1:String, puntosJug2:Double, nombreJug2:String) : String{
        var ganador = ""

        //Si el jugador 1 tiene más puntos que el 2 pero no se ha pasado de 7.5 o el jugador 2 se ha pasado de 7.5 y el jugador 1 no
        if ((puntosJug1 > puntosJug2 && puntosJug1 <= 7.5) || (puntosJug1 <= 7.5 && puntosJug2 > 7.5)){
            //Gana el jugador 1
            ganador = "ENHORABUENA! Ha ganado $nombreJug1"
        }else //Si el jugador 2 tiene más puntos que el 1 pero no se pasa de 7.5 o el jugador 1 se ha pasado de 7.5 y el jugador 2 no
            if ((puntosJug1 < puntosJug2 && puntosJug2 <= 7.5) || (puntosJug2 <= 7.5 && puntosJug1 > 7.5)) {
                //Gana el jugador 2
                ganador = "ENHORABUENA! Ha ganado $nombreJug2"
            } else //Si ambos se pasan de 7.5 o ambos tienen la misma cantidad de puntos
                if ((puntosJug1 > 7.5 && puntosJug2 > 7.5) || puntosJug1 == puntosJug2) {
                    //No gana ninguno, ambos son malísimos
                    ganador = "Ambos sois unos paquetes"
                }

        //Devolvemos el ganador
        return ganador
    }

}