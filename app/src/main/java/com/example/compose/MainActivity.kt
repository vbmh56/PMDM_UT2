package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaInscripcion(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CampoEmail(
    email: String,
    onEmailChange: (String) -> Unit
) {
    TextField(
        value = email,
        onValueChange = onEmailChange,
        label = { Text("Email") }
    )
}

@Composable
fun CampoNombre(
    nombre: String,
    onNombreChange: (String) -> Unit
) {
    TextField(
        value = nombre,
        onValueChange = onNombreChange,
        label = { Text("Nombre") }
    )
}

@Composable
fun PantallaInscripcion(modifier: Modifier = Modifier) {

    var nombre by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text("Inscripción")

        CampoNombre(
            nombre = nombre,
            onNombreChange = { nuevoNombre ->
                nombre = nuevoNombre
            }
        )

        CampoEmail(
            email = email,
            onEmailChange = { nuevoEmail ->
                email = nuevoEmail
            }
        )

        Button(
            onClick = {
                println("Nombre: $nombre, email: $email")
            }
        ) {
            Text("Continuar")
        }
    }
}


@Composable
fun ActividadItem(
    nombre: String,
    categoria: String
) {
    Column (
        modifier = Modifier.padding(16.dp)
    ){
        Image(
            painter = painterResource(R.drawable.baseline_60fps_24),
            contentDescription = "Imagen de la actividad",
            modifier = Modifier.size(200.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(text = nombre)
            Text(text = categoria)
        }
        Button(
            onClick = {
                println("Botón pulsado")
            }
        ) {
            Text("Ver detalle")
        }
    }
}

@Composable
fun PantallaActividades() {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    )
    {
        ActividadItem(
            nombre = "Taller de Android",
            categoria = "Tecnología"
        )
        ActividadItem(
            nombre = "Taller de Kotlin",
            categoria = "Tecnología"
        )
        ActividadItem(
            nombre = "Taller deportivo",
            categoria = "Deporte"
        )
    }
}