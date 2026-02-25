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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.olimpicfantasy.ui.auth.AuthViewModel
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


                        RegisterScreen(
                            onNavigateToLogin = {
                                println("Botón ir a login pulsado")
                            },
                            onRegisterClick = { nombre, email, password ->

                                authViewModel.registrarUsuario(nombre, email, password)
                            }
                        )

                    }
                }
            }
        }
    }
}