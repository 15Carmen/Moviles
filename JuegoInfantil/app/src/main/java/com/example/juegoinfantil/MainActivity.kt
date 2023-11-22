package com.example.juegoinfantil

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var imgGato : ImageView? = null
    private var imgLobo : ImageView? = null
    private var imgPerro : ImageView? = null
    private var imgPato : ImageView? = null
    private var imgPajaro : ImageView? = null
    private var mediaplayerGato : MediaPlayer? = null
    private var mediaPlayerLobo : MediaPlayer? = null
    private var mediaPlayerPerro : MediaPlayer? = null
    private var mediaPlayerPato : MediaPlayer? = null
    private var mediaPlayerPajaro : MediaPlayer? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaplayerGato = MediaPlayer.create(this, R.raw.gato)
        mediaPlayerLobo = MediaPlayer.create(this, R.raw.lobo)
        mediaPlayerPerro = MediaPlayer.create(this, R.raw.perro)
        mediaPlayerPato = MediaPlayer.create(this, R.raw.pato)
        mediaPlayerPajaro = MediaPlayer.create(this, R.raw.pajaro)

        imgGato!!.setOnClickListener(this);
        imgLobo!!.setOnClickListener(this);
        imgPerro!!.setOnClickListener(this);
        imgPato!!.setOnClickListener(this);
        imgPajaro!!.setOnClickListener(this);

    }

    override fun onClick(v: View) {
        when (v.getId()){
            R.id.gato -> mediaplayerGato!!.start()
            R.id.lobo -> mediaPlayerLobo!!.start()
            R.id.perro -> mediaPlayerPerro!!.start()
            R.id.pato -> mediaPlayerPato!!.start()
            R.id.pajaro -> mediaPlayerPajaro!!.start()

        }
    }


}