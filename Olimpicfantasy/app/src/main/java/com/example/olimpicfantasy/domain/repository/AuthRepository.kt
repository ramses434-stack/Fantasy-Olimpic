package com.example.olimpicfantasy.domain.repository

import com.example.olimpicfantasy.domain.model.UserID

interface AuthRepository {

    suspend fun login(email: String,password:String): Result<UserID>
    suspend fun register(nombre:String,email: String,password: String): Result<UserID>


}