package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otra_vista)

        val PI: Double = 3.1416
        var numero: Int = 7
        var exponente : Int = 3
        var resultado: Double = PI + numero

        Log.d("ETIQUETA", potencia(numero, exponente))

        Log.d("ETIQUETA", resultado.toString())
    }

    private fun potencia(numero: Int, exponente: Int): String {

        /*
        var resultado: Int = 1

        for (i in 1..exponente) {
            resultado *= numero
        }
        */
        var resultado:Int = numero.toDouble().pow(exponente.toDouble()).toInt()

        return ("El numero $numero elevado a $exponente es igual a $resultado")
    }


}