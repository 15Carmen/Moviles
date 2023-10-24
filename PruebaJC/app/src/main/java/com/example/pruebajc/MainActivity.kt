package com.example.pruebajc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pruebajc.ui.theme.PruebaJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row {
        Column() {
            Text(
                text = "Hello ",
                fontSize = 48.sp,
                modifier = Modifier.padding(8.dp),
                color = Color(223, 27, 16, 47)
            )
        }
        Column {
            Text(
                text = "world!",
                fontSize = 48.sp,
                modifier = Modifier.padding(8.dp),
                color = Color(23, 114, 125, 225)
            )
        }

    }
    AsyncImage(
        model = "https://cdn.pixabay.com/photo/2018/04/26/12/14/travel-3351825_1280.jpg",
        contentDescription = "gatete",
        Modifier.size(400.dp, 400.dp)
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PruebaJCTheme {
        Greeting("Pablo")
    }
}