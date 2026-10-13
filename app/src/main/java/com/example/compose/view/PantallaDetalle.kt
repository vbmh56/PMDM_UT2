package com.example.compose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose.model.Actividad

@Composable
fun PantallaDetalle(
    actividad: Actividad,
    onInscribirse: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Image(
            painter = painterResource(actividad.imagen),
            contentDescription = actividad.nombre,
            modifier = Modifier.size(160.dp)
        )

        Text(
            text = actividad.nombre
        )

        Text(
            text = actividad.categoria
        )

        Text(
            text = actividad.descripcion
        )

        Text(
            text = actividad.modalidad
        )

        Button(
            onClick = onInscribirse
        ) {
            Text("Inscribirse")
        }
    }
}