package com.example.olimpicfantasy.ui.auth


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.olimpicfantasy.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repository = AuthRepositoryImpl()


    fun registrarUsuario(nombre: String, email: String, password: String) {

        viewModelScope.launch {
            println("⏳ Intentando registrar usuario...")

            val resultado = repository.register(nombre, email, password)

            if (resultado.isSuccess) {

                println("✅ ¡ÉXITO! Usuario guardado en Supabase con ID: ${resultado.getOrNull()?.value}")
            } else {

                println("❌ ERROR al registrar: ${resultado.exceptionOrNull()?.message}")
            }
        }
    }
}