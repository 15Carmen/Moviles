package com.example.calculadora

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.calculadora.databinding.CalculadoraBinding
import com.example.calculadora.databinding.LoginBinding
import com.example.calculadora.databinding.PauseBinding


class MainActivity : ComponentActivity() {


    class MainActivity : AppCompatActivity() {

        var parar = false
        var nombre = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            Log.i("act", "on create")

        }

        override fun onStart() {

            super.onStart()

            Log.i("act", "on start")

        }

        override fun onResume() {

            super.onResume()

            Log.i("act", "on resume")


            val loginBinding = LoginBinding.inflate(layoutInflater)
            val calculadoraBinding = CalculadoraBinding.inflate(layoutInflater)

            setContentView(loginBinding.root)

            var boton = loginBinding.btnAcceder
            var vuelta = calculadoraBinding.btnBack
            var suma = calculadoraBinding.btnSuma
            var resta = calculadoraBinding.btnResta
            var mult = calculadoraBinding.btnMulti
            var div = calculadoraBinding.btnDiv
            var numUno = calculadoraBinding.numPrimerFact.text.toString()
            var numDos = calculadoraBinding.numSegundoFact.text.toString()

            if (parar) {

                setContentView(calculadoraBinding.root)

                parar = false


            } else {

                //El botón que va del login hacia la calculadora
                boton.setOnClickListener {

                    val toast = Toast.makeText(
                        applicationContext,
                        "Palante",
                        Toast.LENGTH_SHORT
                    ).show()

                    //vista de la calculadora
                    setContentView(calculadoraBinding.root)


                    //botón que va de la calculadora al login
                    vuelta.setOnClickListener() {

                        val toast = Toast.makeText(
                            applicationContext,
                            "Patrás",
                            Toast.LENGTH_SHORT
                        ).show()

                        setContentView(loginBinding.root)

                    }

                    var numUno = calculadoraBinding.numPrimerFact.text.toString()
                    var numDos = calculadoraBinding.numSegundoFact.text.toString()

                    //botón que suma
                    suma.setOnClickListener() {

                        var res = 0.0

                        if (numUno.isEmpty()) {

                            Log.i("act", "el primer num era 0")
                            var uno = numUno.toDouble()
                            uno = 0.0

                            res = (uno.toDouble()) + (numDos.toDouble())


                        } else if (numDos.isEmpty()) {

                            Log.i("act", "el segundo num era 0")
                            var dos = numDos.toDouble()

                            dos = 0.0

                            res = (numUno.toDouble()) + (dos.toDouble())


                        } else {

                            Log.i("act", "suma")

                            res = (numUno.toDouble()) + (numDos.toDouble())
                        }


                        calculadoraBinding.res.text = "$res"
                    }

                    //botón que resta
                    resta.setOnClickListener() {

                        var res = 0.0

                        if (numUno.isEmpty()) {

                            Log.i("act", "el primer num era 0")
                            var uno = numUno.toDouble()
                            uno = 0.0

                            res = (uno.toDouble()) - (numDos.toDouble())


                        } else if (numDos.isEmpty()) {

                            Log.i("act", "el segundo num era 0")
                            var dos = numDos.toDouble()

                            dos = 0.0

                            res = (numUno.toDouble()) - (dos.toDouble())


                        } else {

                            Log.i("act", "suma")

                            res = (numUno.toDouble()) - (numDos.toDouble())
                        }


                        calculadoraBinding.res.text = "$res"
                    }

                    //botón que suma
                    mult.setOnClickListener() {

                        var res = 0.0

                        if (numUno.isEmpty()) {

                            Log.i("act", "el primer num era 0")
                            var uno = numUno.toDouble()
                            uno = 0.0

                            res = (uno.toDouble()) * (numDos.toDouble())


                        } else if (numDos.isEmpty()) {

                            Log.i("act", "el segundo num era 0")
                            var dos = numDos.toDouble()

                            dos = 0.0

                            res = (numUno.toDouble()) * (dos.toDouble())


                        } else {

                            Log.i("act", "suma")

                            res = (numUno.toDouble()) * (numDos.toDouble())
                        }


                        calculadoraBinding.res.text = "$res"
                    }


                }
            }

        }

        override fun onPause() {
            super.onPause()

            Log.i("act", "onpause")
            Toast.makeText(applicationContext, "He parado", Toast.LENGTH_SHORT).show()

            val pausa = PauseBinding.inflate(layoutInflater)
            setContentView(pausa.root)

            parar = true


        }

        override fun onStop() {
            super.onStop()
            Log.i("actividad", "on stop")

            onRestart()

        }

        override fun onRestart() {
            super.onRestart()

            Log.i("act", "onRestrart")

            Toast.makeText(applicationContext, "Bienvenido de vuelta", Toast.LENGTH_SHORT).show()


            val calcB =
                com.example.calculadora.databinding.CalculadoraBinding.inflate(layoutInflater)
            setContentView(calcB.root)


        }

        override fun onDestroy() {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channelId = "mi_canal_id"
                val channelName = "Mi Canal de Notificación"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(channelId, channelName, importance)

                val notificationManager = getSystemService(NotificationManager::class.java)
                notificationManager.createNotificationChannel(channel)
            }

            // Crea un intent para abrir una actividad cuando se toque la notificación
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            // Crea la notificación
            val notificationBuilder = NotificationCompat.Builder(this, "mi_canal_id")
                .setSmallIcon(R.drawable.icons8_recordatorios_de_citas_30)
                .setContentTitle("Cierre de sesión")
                .setContentText("Se ha cerrado la sesión de $nombre")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) // Cierra la notificación al tocarla
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            // Muestra la notificación
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.notify(1, notificationBuilder.build())

            super.onDestroy()
        }
    }
}

