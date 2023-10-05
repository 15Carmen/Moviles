package com.example.logingscreen

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.logingscreen.databinding.LoginBinding
import com.example.logingscreen.databinding.PauseBinding
import com.example.logingscreen.databinding.WelcomeBinding


class MainActivity : Activity() {


    // Declaro las variables globales
    var nombre = ""     //variable donde vamos a guardar el nombre introducido por el usuario
    var parar = false   //Variable booleana que usaremos para saber si la aplicación está en pausa o no


    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("TAG", "Create")

        //Creamos un binding para la pantalla del login
        val bindingLogin = LoginBinding.inflate(layoutInflater)

        //guardamos en la variable nombre el nombre de usuario introducido en en la pantalla de login
        nombre = bindingLogin.userInput.text.toString()
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "Start")

        //Creamos un binding de la pagina de bienvenida
        val bindingWelcome = WelcomeBinding.inflate(layoutInflater)
        //Cuando la aplicacion esté en funcionamiento mostramos la pantalla de bienvenida
        setContentView(bindingWelcome.root)

    }

    override fun onRestart() {
        super.onRestart()

        Log.d("TAG", "Restart")

        //Cuando se reanude la aplicación mostramos una notificación de bienvenida en la parte de abajo de la pantalla
        Toast.makeText(applicationContext, "Bienvenido de vuelta", Toast.LENGTH_SHORT).show()

        //Creamos un binding de la pantalla de bienvenida
        val bindingWelcome = WelcomeBinding.inflate(layoutInflater)
        //Cuando se reinicie la app mostramos la pantalla de bienvenida
        setContentView(bindingWelcome.root)
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "Resume")

        //Creamos un binding tanto de la pantalla de login como de la de bienvenida
        val bindingLogin = LoginBinding.inflate(layoutInflater)
        val bindingWelcome = WelcomeBinding.inflate(layoutInflater)

        //En una variable boton guardamos el boton que tenemos creado en la pantalla de login
        var boton = bindingLogin.btnAcceder


        //Si la app estaba en pausa
        if (parar) {
            //Mostramos la pantalla de bienvenida
            setContentView(bindingWelcome.root)

            //Mostramos en la pantalla un mensaje de bienvenida
            bindingWelcome.txtWelcome.text = "Bienvenido de vuelta, $nombre "

            //Indicamos que parar ya es falso
            parar = false

        } else { //Si la app no estaba en pausa

            //Mostramos la pantalla de login
            setContentView(bindingLogin.root)

            //Cuando se clique el boton de la pantalla de login
            boton.setOnClickListener {

                //Mostramos una notificación de bienvenida en la parte de abajo de la pantalla
                Toast.makeText(applicationContext, "Hello", Toast.LENGTH_SHORT).show()

                //Mostramos la pantalla de bienvenida
                setContentView(bindingWelcome.root)

                //Cambiamos el mensaje de la pantalla para que de la bienvenida al usuario por su nombre
                bindingWelcome.txtWelcome.text = "Bienvenido de vuelta $nombre"
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
            .setSmallIcon(R.drawable.noti_icon)
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




