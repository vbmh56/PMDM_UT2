package com.example.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun PantallaInscripcion(modifier: Modifier = Modifier) {

    var nombre by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }

    var recordatorio by remember {
        mutableStateOf(false)
    }

    var turno by remember {
        mutableStateOf("Mañana")
    }

    Column(
        modifier = modifier.padding(16.dp),
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

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = recordatorio,
                onCheckedChange = { nuevoValor ->
                    recordatorio = nuevoValor
                }
            )

            Text("Quiero recibir un recordatorio")
        }

        Button(
            onClick = {
                println("Nombre: $nombre, " +
                        "email: $email, " +
                        "recordatorio: $recordatorio ")
            }
        ) {
            Text("Continuar")
        }
    }
}