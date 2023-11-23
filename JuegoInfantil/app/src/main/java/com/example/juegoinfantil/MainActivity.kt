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
    private var mediaPlayer : MediaPlayer?=null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgGato!!.setOnClickListener(this);
        imgLobo!!.setOnClickListener(this);
        imgPerro!!.setOnClickListener(this);
        imgPato!!.setOnClickListener(this);
        imgPajaro!!.setOnClickListener(this);

    }

    override fun onClick(v: View) {
        when (v.getId()){
            R.id.gato -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.gato)
                mediaPlayer!!.start()
            }

            R.id.lobo -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.lobo)
                mediaPlayer!!.start()
            }
            R.id.perro -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.perro)
                mediaPlayer!!.start()
            }
            R.id.pato -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.pato)
                mediaPlayer!!.start()
            }
            R.id.pajaro -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.pajaro)
                mediaPlayer!!.start()
            }

        }
    }


}