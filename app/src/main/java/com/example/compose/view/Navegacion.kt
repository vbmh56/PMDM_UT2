package com.example.compose.view

import kotlinx.serialization.Serializable

@Serializable
data object Actividades

@Serializable
data class Detalle(
    val actividadId: Int
)

@Serializable
data class Inscripcion(
    val actividadId: Int
)