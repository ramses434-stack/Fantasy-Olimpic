package com.example.olimpicfantasy.data.repository

import com.example.olimpicfantasy.data.SupabaseHelper
import com.example.olimpicfantasy.domain.model.UserID
import com.example.olimpicfantasy.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

class AuthRepositoryImpl : AuthRepository {

    override suspend fun register(nombre: String, email: String, password: String): Result<UserID> {
        return try {
            val supabase = SupabaseHelper.client

            supabase.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }


            val idGenerado = supabase.auth.currentSessionOrNull()?.user?.id ?: ""


            Result.success(UserID(idGenerado))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun login(email: String, password: String): Result<UserID> {
        return try {
            val supabase = SupabaseHelper.client

            supabase.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }

            val idGenerado = supabase.auth.currentSessionOrNull()?.user?.id ?: ""

            Result.success(UserID(idGenerado))

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}