package com.example.mvvm_login_jc.ui.theme.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvm_login_jc.R



@Composable
fun LoginScreen(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)){
        Login(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Login(modifier: Modifier) {
    Column (modifier = modifier){
        HeaderImage(
            Modifier
                .align(Alignment.CenterHorizontally)
                .size(250.dp))
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField()
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField()
        Spacer(modifier = Modifier.padding(16.dp))
        LoginButton()
    }
}

@Composable
fun LoginButton() {
    Button(onClick = { /*TODO*/ }, modifier = Modifier
        .fillMaxWidth()
        .height(48.dp), colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF5722),
            disabledContainerColor = Color(0xFFFF9800),
            contentColor = Color.White,
            disabledContentColor = Color.White

    )) {
        Text(text = "Iniciar sesión")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField() {

    TextField(
        value = "",
        onValueChange = {},
        placeholder = { Text(text = "Contraseña")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), //para que cuando escribimos la contraseña aparezcan puntos en ves de las letras
        singleLine = true, // Para que cuando se le de a enter no amplie el textField
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF494848), //Si pones Color y dentro de los parentesis 0x + 8 efes (0xFFFFFFF) puedes elegir el color que quieras
            containerColor = Color(0xFFF89992)
        )
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmailField() {

    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = "Email")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), //para que nos aparezca el @ en el teclado
        singleLine = true, // Para que cuando se le de a enter no amplie el textField
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF494848), //Si pones Color y dentro de los parentesis 0x + 8 efes (0xFFFFFFF) puedes elegir el color que quieras
            containerColor = Color(0xFFF89992)
        )
    )

}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.this_is_fine),
        contentDescription = "this_is_fine",
        modifier = modifier
    )

}