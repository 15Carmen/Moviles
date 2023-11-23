package com.example.juegoinfantiljc
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.juegoinfantiljc.ui.theme.JuegoInfantilJCTheme

class MainActivity : ComponentActivity() {

    var mediaPlayer: MediaPlayer? = null
    var sensorManager=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JuegoInfantilJCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Jueguito()
                    queSeTeCae(this)
                }
            }
        }
    }

    override fun onPause(){
        super.onPause()

        mediaPlayer?.stop()
        mediaPlayer?.release()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.stop()
        mediaPlayer?.release()
    }

    private fun queSeTeCae(context: Context) {
        //Inicializamos el sensor de aceleracion
        val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sensorManager.registerListener(
            object  : SensorEventListener{
                //si se agita el movil, reproducir sonido de cristales
                override fun onSensorChanged(event: SensorEvent?) {
                    if (event != null) {
                        if (event.values[0] > 24 || event.values[1] > 24 || event.values[2] > 24) {
                            mediaPlayer = MediaPlayer.create(context, R.raw.cristales)
                            mediaPlayer?.start()
                        }
                    }
                }

                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                    TODO("Not yet implemented")
                }
            },
            sensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }


}



@Composable
fun Jueguito(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .background(Color.White)
        .verticalScroll(rememberScrollState()), //Para poder scrollear
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Image(painter = painterResource(R.drawable.pato), contentDescription = "pato",
            modifier=Modifier.size(200.dp).clickable {

                val mMediaPlayer = MediaPlayer.create(context, R.raw.pato)
                mMediaPlayer.start()

            })

        Image(painter = painterResource(R.drawable.gato), contentDescription = "gato",
            modifier=Modifier.size(200.dp).clickable {

                val mMediaPlayer = MediaPlayer.create(context, R.raw.gato)
                mMediaPlayer.start()

            })

        Image(painter = painterResource(R.drawable.perro), contentDescription = "perro",
            modifier=Modifier.size(200.dp).clickable {

                val mMediaPlayer = MediaPlayer.create(context, R.raw.perro)
                mMediaPlayer.start()

            })

        Image(painter = painterResource(R.drawable.lobo), contentDescription = "lobo",
            modifier=Modifier
                    .size(200.dp)
                    .clickable {

                val mMediaPlayer = MediaPlayer.create(context, R.raw.lobo)
                mMediaPlayer.start()

            } )

        Image(painter = painterResource(id = R.drawable.pajaro), contentDescription = "pajaro",
            modifier = Modifier.size(180.dp).clickable {

                val mMediaPlayer = MediaPlayer.create(context, R.raw.pajaro)
                mMediaPlayer.start()

            })

    }


}




/**
 * Previsualizacion del juego
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JuegoInfantilJCTheme {
        Jueguito()
    }
}