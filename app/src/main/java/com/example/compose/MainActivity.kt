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
                    CampoNombre(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaInscripcion() {

    var nombre by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text("Inscripción")

        TextField(
            value = nombre,
            onValueChange = { nuevoNombre ->
                nombre = nuevoNombre
            },
            label = {
                Text("Nombre")
            }
        )

        Button(
            onClick = {
                println("Nombre: $nombre")
            }
        ) {
            Text("Continuar")
        }
    }
}

@Composable
fun CampoNombre(modifier: Modifier = Modifier) {

    var nombre by remember {
        mutableStateOf("")
    }

    Column {

        TextField(
            value = nombre,
            onValueChange = { nuevoNombre ->
                nombre = nuevoNombre
            }
        )

        Text("Nombre introducido: $nombre")
    }
}

@Composable
fun Contador(modifier: Modifier = Modifier) {

    var contador by remember {
        mutableIntStateOf(10)
    }

    Column(modifier = modifier) {
        Text("Has pulsado $contador veces")

        Button(
            onClick = {
                contador+=2
            }
        ) {
            Text("Pulsar")
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