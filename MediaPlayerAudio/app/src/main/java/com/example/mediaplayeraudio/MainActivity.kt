package com.example.mediaplayeraudio

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.io.IOException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var btnPlay: Button? = null
    private var btnPause: Button? = null
    private var btnStop: Button? = null
    private var mediaplayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaplayer = MediaPlayer.create(this, R.raw.lol);

        //Obtenemos los tres botones de la interfaz
        btnPlay= findViewById(R.id.buttonPlay);
        btnStop= findViewById(R.id.buttonStop);
        btnPause= findViewById(R.id.buttonPause);

        //Y les asignamos el controlador de eventos
        btnPlay!!.setOnClickListener(this);
        btnStop!!.setOnClickListener(this);
        btnPause!!.setOnClickListener(this);
    }
    override fun onClick(v: View) {
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        when (v.getId()) {
            R.id.buttonPlay ->                 //Iniciamos el audio
                mediaplayer!!.start()
            R.id.buttonPause ->                 //Pausamos el audio
                mediaplayer!!.pause()
            R.id.buttonStop ->                 //Paramos el audio y volvemos a inicializar
                try {
                    mediaplayer!!.stop()
                    mediaplayer!!.prepare()
                    mediaplayer!!.seekTo(0)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
        }
    }
}