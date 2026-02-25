package com.example.olimpicfantasy.domain.usecase

import com.example.olimpicfantasy.domain.model.UserID
import com.example.olimpicfantasy.domain.repository.AuthRepository

class LoginUsecase(private val repository: AuthRepository){

    suspend operator fun invoke(email: String,password: String): Result<UserID>{
        if(!email.contains("@")){
            return Result.failure(Exception("email nol valido "))
        }
        if(password.length<6 ){
            return Result.failure(Exception("Contraseña no valida"))
        }
        return repository.login(email,password)
    }
}