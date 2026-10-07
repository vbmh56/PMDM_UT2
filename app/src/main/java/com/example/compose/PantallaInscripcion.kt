package com.example.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
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
fun CampoRecordatorio(
    texto: String,
    recordatorio: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = recordatorio,
            onCheckedChange = onCheckedChange
        )

        Text(texto)
    }
}

@Composable
fun CampoTurno(
    textoTurno1: String,
    textoTurno2: String,
    turno:String,
    onClick: () -> Unit
)
{
    Text("Elige un turno")

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = turno == textoTurno1,
            onClick = onClick
        )

        Text(textoTurno1)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = turno == textoTurno2,
            onClick = onClick
        )

        Text(textoTurno2)
    }
}

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

    var resumen by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
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

        CampoRecordatorio(
            texto = "Quiero recibir un recordatorio",
            recordatorio = recordatorio,
            onCheckedChange = { nuevoValor ->
                recordatorio = nuevoValor
            }
        )

        Text("Elige un turno")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = turno == "Mañana",
                onClick = {
                    turno = "Mañana"
                }
            )

            Text("Mañana")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = turno == "Tarde",
                onClick = {
                    turno = "Tarde"
                }
            )

            Text("Tarde")
        }


        Button(
            onClick = {
                val aviso = if (recordatorio) "Sí" else "No"

                resumen = "Nombre: $nombre\n" +
                        "Correo: $email\n" +
                        "Turno: $turno\n" +
                        "Recordatorio: $aviso"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continuar")
        }
        if (resumen.isNotEmpty()) {
            Text("Resumen de la inscripción")
            Text(resumen)
        }
    }
}