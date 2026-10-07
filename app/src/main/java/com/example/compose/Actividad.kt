package com.example.compose

import androidx.annotation.DrawableRes

data class Actividad(
    val id: Int,
    val nombre: String,
    val categoria: String,
    val descripcion: String,
    @get:DrawableRes val imagen: Int,
    val modalidad: String = "Presencial"
)

val actividadesEjemplo = listOf(
    Actividad(
        id = 1,
        nombre = "Taller de Android",
        categoria = "Tecnología",
        descripcion = "Construye tu primera aplicación con Compose.",
        imagen = R.drawable.baseline_60fps_24
    ),
    Actividad(
        id = 2,
        nombre = "Ruta de senderismo",
        categoria = "Deporte",
        descripcion = "Recorre una ruta sencilla en grupo.",
        imagen = R.drawable.baseline_60fps_24
    ),
    Actividad(
        id = 3,
        nombre = "Fotografía con el móvil",
        categoria = "Arte",
        descripcion = "Practica encuadres y composición.",
        imagen = R.drawable.baseline_60fps_24
    )
)