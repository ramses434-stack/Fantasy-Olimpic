package com.example.olimpicfantasy.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.olimpicfantasy.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repository = AuthRepositoryImpl()


    fun registrarUsuario(
        nombre: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            val resultado = repository.register(nombre, email, password)

            if (resultado.isSuccess) {

                onSuccess()
            } else {

                onError(resultado.exceptionOrNull()?.message ?: "Error desconocido")
            }
        }
    }
}