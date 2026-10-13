package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.compose.model.actividadesEjemplo
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.view.PantallaActividades
import com.example.compose.view.PantallaDetalle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaDetalle(
                        actividad = actividadesEjemplo[1],
                        onInscribirse = {
                            println("Inscribirse")
                        }
                    )
                }
            }
        }
    }
}



