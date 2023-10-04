package com.example.logingscreen

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.logingscreen.databinding.LoginBinding
import com.example.logingscreen.databinding.PauseBinding
import com.example.logingscreen.databinding.WelcomeBinding


class MainActivity : Activity() {


    var nombre = ""
    var parar = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.d("TAG", "Create")

        val bindingLogin = LoginBinding.inflate(layoutInflater)
        nombre = bindingLogin.userInput.text.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "Start")

        val bindingWelcome= WelcomeBinding.inflate(layoutInflater)
        setContentView(bindingWelcome.root)

    }

    override fun onRestart() {
        super.onRestart()

        Log.d("TAG", "Restart")

        Toast.makeText(applicationContext, "Bienvenido de vuelta", Toast.LENGTH_SHORT).show()

        val restart = WelcomeBinding.inflate(layoutInflater)
        setContentView(restart.root)
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "Resume")

        val bindingLogin = LoginBinding.inflate(layoutInflater)
        val bindingWelcome = WelcomeBinding.inflate(layoutInflater)

        var boton = bindingLogin.btnAcceder


        if (parar){
            setContentView(bindingWelcome.root)
            bindingWelcome.txtWelcome.text = "Bienvenido de vuelta " + nombre

            parar = false

        } else{

            setContentView(bindingLogin.root)

            boton.setOnClickListener {

                val toast = Toast.makeText(
                    applicationContext, "Hello", Toast.LENGTH_SHORT
                ).show()

                setContentView(bindingWelcome.root)

                bindingWelcome.txtWelcome.text = "Bienvenido de vuelta " + nombre
            }
        }

    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "Pause")

        Toast.makeText(applicationContext, "Aplicacion en pausa", Toast.LENGTH_SHORT).show()

        val pauseBinding = PauseBinding.inflate(layoutInflater)
        setContentView(pauseBinding.root)

        parar = true
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "Stop")

        onRestart()
    }



    override fun onDestroy() {
        super.onDestroy()

        Log.d("TAG", "Destroy")
    }

    /*
    override fun onDestroy() {
        super.onDestroy()
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
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        // Crea la notificación
        val notificationBuilder = NotificationCompat.Builder(this, "mi_canal_id")
            .setSmallIcon(R.drawable.ic_notificacion)
            .setContentTitle("Cierre de sesión")
            .setContentText("Se ha cerrado la sesión de $nombre")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true) // Cierra la notificación al tocarla
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Muestra la notificación
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(1, notificationBuilder.build())

    }


*/

}