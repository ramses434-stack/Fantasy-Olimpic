package com.example.olimpicfantasy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.olimpicfantasy.ui.theme.OlimpicFantasyTheme
// ¡Importante! Aquí importamos tu nueva pantalla
import com.example.olimpicfantasy.ui.auth.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OlimpicFantasyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    Box(modifier = Modifier.padding(innerPadding)) {


                        LoginScreen(
                            onNavigateToRegister = {
                                // De momento lo dejamos vacío.
                                // Más adelante aquí pondremos el código para cambiar de pantalla.
                                println("Botón Registro pulsado")
                            },
                            onLoginClick = { email, password ->
                                // Aquí conectaremos con la lógica (UseCase) para comprobar el usuario
                                println("Intentando login con: $email y $password")
                            }
                        )

                    }
                }
            }
        }
    }
}