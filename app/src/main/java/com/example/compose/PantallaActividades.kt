package com.example.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ActividadItem(actividad: Actividad) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(actividad.imagen),
            contentDescription = actividad.nombre,
            modifier = Modifier.size(80.dp)
        )

        Text(actividad.nombre)

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(actividad.categoria)
            Text(actividad.modalidad)
        }

        Button(
            onClick = {
                println("Actividad seleccionada: ${actividad.nombre}")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver actividad")
        }
    }
}

@Composable
fun PantallaActividades(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(actividadesEjemplo) { actividad ->
            ActividadItem(actividad = actividad)
        }
    }
}