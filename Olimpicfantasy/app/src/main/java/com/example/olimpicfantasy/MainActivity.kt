package com.example.olimpicfantasy

import android.os.Bundle
import android.widget.Toast // Herramienta para los mensajitos emergentes
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.* // Herramientas para el estado de navegación
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.olimpicfantasy.ui.auth.AuthViewModel
import com.example.olimpicfantasy.ui.auth.LoginScreen // Tu pantalla de login
import com.example.olimpicfantasy.ui.auth.RegisterScreen
import com.example.olimpicfantasy.ui.theme.OlimpicFantasyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OlimpicFantasyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {

                        val authViewModel: AuthViewModel = viewModel()
                        val context = LocalContext.current // Necesario para mostrar el Toast

                        // Esta variable es nuestro "mando a distancia" de las pantallas
                        var pantallaActual by remember { mutableStateOf("registro") }


                        if (pantallaActual == "registro") {
                            RegisterScreen(
                                onNavigateToLogin = {
                                    pantallaActual = "login" //
                                },
                                onRegisterClick = { nombre, email, password ->
                                    authViewModel.registrarUsuario(
                                        nombre = nombre,
                                        email = email,
                                        password = password,
                                        onSuccess = {

                                            Toast.makeText(context, "¡Cuenta creada con éxito!", Toast.LENGTH_LONG).show()

                                            pantallaActual = "login"
                                        },
                                        onError = { mensajeError ->

                                            Toast.makeText(context, "Error: $mensajeError", Toast.LENGTH_LONG).show()
                                        }
                                    )
                                }
                            )
                        }

                        else if (pantallaActual == "login") {
                            LoginScreen(
                                onNavigateToRegister = {
                                    pantallaActual = "registro"
                                },
                                onLoginClick = { email, password ->
                                    Toast.makeText(context, "Intentando login...", Toast.LENGTH_SHORT).show()
                                }
                            )
                        }

                    }
                }
            }
        }
    }
}