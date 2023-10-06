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
import androidx.core.app.NotificationCompat
import com.example.calculadora.databinding.CalculadoraBinding
import com.example.calculadora.databinding.LoginBinding
import com.example.calculadora.databinding.PauseBinding


class MainActivity : ComponentActivity() {

    // Declaro las variables globales
    var parar = false   //Variable booleana que usaremos para saber si la aplicación está en pausa o no


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.d("TAG", "Create")

        //Declaramos los bindings
        val bindingCalculadora = CalculadoraBinding.inflate(layoutInflater)

        //Mostramos primero la vista de la calculadora
        setContentView(bindingCalculadora.root)


    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "Start")

        //Creamos un binding de la pagina de bienvenida
        val bindingCalculadora = CalculadoraBinding.inflate(layoutInflater)
        //Cuando la aplicacion esté en funcionamiento mostramos la pantalla de calculadora
        setContentView(bindingCalculadora.root)

    }

    override fun onRestart() {
        super.onRestart()

        Log.d("TAG", "Restart")

        //Cuando se reanude la aplicación mostramos una notificación de bienvenida en la parte de abajo de la pantalla
        Toast.makeText(applicationContext, "Bienvenido de vuelta", Toast.LENGTH_SHORT).show()

        //Creamos un binding de la pantalla de bienvenida
        val bindingCalculadora = CalculadoraBinding.inflate(layoutInflater)
        //Cuando se reinicie la app mostramos la pantalla de bienvenida
        setContentView(bindingCalculadora.root)
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "Resume")

        //Creamos un binding tanto de la pantalla de login como de la de calculadora
        val bindingLogin = LoginBinding.inflate(layoutInflater)
        val bindingCalculadora = CalculadoraBinding.inflate(layoutInflater)

        setContentView(bindingLogin.root)

        //Si la app estaba en pausa
        if (parar) {
            //Mostramos la pantalla de calculadora
            setContentView(bindingCalculadora.root)

            //Indicamos que parar ya es falso
            parar = false

        } else { //Si la app no estaba en pausa

            //Mostramos la pantalla de login
            setContentView(bindingLogin.root)

            //Declaramos las variables
            var res = 0.0   //Resultado de la operación
            var boton = bindingLogin.btnAcceder

            /**
             * Acción que se realiza al clicar el boton de acceso
             */
            boton.setOnClickListener {

                //Mostramos la pantalla de calculadora
                setContentView(bindingCalculadora.root)

            }

            /**
             * Acción que se realiza al clicar el botón de atrás
             */
            bindingCalculadora.btnBack.setOnClickListener {
                //Mostramos la pantalla del login
                setContentView(bindingLogin.root)
            }

            /**
             * Acción que se realiza al clicar el boton suma
             */
            bindingCalculadora.btnSuma.setOnClickListener {
                val num1 = bindingCalculadora.primerFactorInput.text.toString()     //Guardamos aqui el primer numero introducido
                val num2 = bindingCalculadora.segundoFactorInput.text.toString()    //Guardamos el segundo numero introducido

                //Si ninguno de los campos numero está vacio
                if (num1.isNotBlank() && num2.isNotBlank()) {
                    //Se realiza la operación
                    res = (num1.toDouble() + num2.toDouble())
                    //Mostramos el resultado en la pantalla
                    bindingCalculadora.resultadoOutput.text = "$res"

                } else {    //Si alguno de los campos está vacío
                    //Mostramos que el resultado es 0 y lanzamos un mensaje de error
                    bindingCalculadora.resultadoOutput.text = "0"
                    Toast.makeText(
                        this,
                        "Para hacer la operación se necesitan dos valores",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            /**
             * Acción que se realiza al clicar el boton resta
             */
            bindingCalculadora.btnResta.setOnClickListener {
                val num1 = bindingCalculadora.primerFactorInput.text.toString()     //Guardamos aqui el primer numero introducido
                val num2 = bindingCalculadora.segundoFactorInput.text.toString()    //Guardamos el segundo numero introducido
                //Si ninguno de los campos numero está vacio
                if (num1.isNotBlank() && num2.isNotBlank()) {
                    //Se realiza la operación
                    res = (num1.toDouble() - num2.toDouble())
                    //Mostramos el resultado en la pantalla
                    bindingCalculadora.resultadoOutput.text = "$res"

                } else {    //Si alguno de los campos está vacío
                    //Mostramos que el resultado es 0 y lanzamos un mensaje de error
                    bindingCalculadora.resultadoOutput.text = "0"
                    Toast.makeText(
                        this,
                        "Para hacer la operación se necesitan dos valores",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            /**
             * Acción que se realiza al clicar el boton multiplicación
             */
            bindingCalculadora.btnMulti.setOnClickListener {
                val num1 = bindingCalculadora.primerFactorInput.text.toString()     //Guardamos aqui el primer numero introducido
                val num2 = bindingCalculadora.segundoFactorInput.text.toString()    //Guardamos el segundo numero introducido
                //Si ninguno de los campos numero está vacio
                if (num1.isNotBlank() && num2.isNotBlank()) {
                    //Se realiza la operación
                    res = (num1.toDouble() * num2.toDouble())
                    //Mostramos el resultado en la pantalla
                    bindingCalculadora.resultadoOutput.text = "$res"

                } else {    //Si alguno de los campos está vacío
                    //Mostramos que el resultado es 0 y lanzamos un mensaje de error
                    bindingCalculadora.resultadoOutput.text = "0"
                    Toast.makeText(
                        this,
                        "Para hacer la operación se necesitan dos valores",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            /**
             * Acción que se realiza al clicar el boton división
             */
            bindingCalculadora.btnDiv.setOnClickListener {
                val num1 = bindingCalculadora.primerFactorInput.text.toString()     //Guardamos aqui el primer numero introducido
                val num2 = bindingCalculadora.segundoFactorInput.text.toString()    //Guardamos el segundo numero introducido
                //Si ninguno de los campos numero está vacio
                if (num1.isNotBlank() && num2.isNotBlank()) {
                    //Se realiza la operación
                    res = (num1.toDouble() / num2.toDouble())
                    //Mostramos el resultado en la pantalla
                    bindingCalculadora.resultadoOutput.text = "$res"

                } else {    //Si alguno de los campos está vacío
                    //Mostramos que el resultado es 0 y lanzamos un mensaje de error
                    bindingCalculadora.resultadoOutput.text = "0"
                    Toast.makeText(
                        this,
                        "Para hacer la operación se necesitan dos valores",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "Pause")

        //Mostramos una notificacion en la parte inferior de la pantalla indicando que la app se enccuentra pausada
        Toast.makeText(applicationContext, "Aplicacion en pausa", Toast.LENGTH_SHORT).show()

        //Creamos un binding de la pantalla de pausa
        val pauseBinding = PauseBinding.inflate(layoutInflater)
        //Mostramos la pantalla de pausa
        setContentView(pauseBinding.root)

        //Indicamos que la app está en pausa
        parar = true
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "Stop")
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
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        // Crea la notificación
        val notificationBuilder = NotificationCompat.Builder(this, "mi_canal_id")
            .setSmallIcon(R.drawable.icons8_recordatorios_de_citas_30)
            .setContentTitle("Cierre de sesión")
            .setContentText("Se ha cerrado la sesión")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true) // Cierra la notificación al tocarla
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Muestra la notificación
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(1, notificationBuilder.build())

        super.onDestroy()
    }
}


