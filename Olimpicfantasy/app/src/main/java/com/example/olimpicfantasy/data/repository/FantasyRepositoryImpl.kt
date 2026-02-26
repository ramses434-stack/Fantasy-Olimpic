package com.example.olimpicfantasy.data.repository

import com.example.olimpicfantasy.data.SupabaseHelper
import com.example.olimpicfantasy.data.model.AtletaDto
import com.example.olimpicfantasy.data.model.toDomain
import com.example.olimpicfantasy.domain.model.Atleta
import com.example.olimpicfantasy.domain.repository.FantasyRepository
import io.github.jan.supabase.postgrest.postgrest

class FantasyRepositoryImpl : FantasyRepository {

    override suspend fun obtenerTodosLosAtletas(): Result<List<Atleta>> {
        return try {
            // 1. Nos conectamos a la tabla 'atletas'
            val supabase = SupabaseHelper.client


            val listaDtos = supabase.postgrest["atletas"]
                .select()
                .decodeList<AtletaDto>()


            val listaLimpia = listaDtos.map { dto -> dto.toDomain() }


            Result.success(listaLimpia)

        } catch (e: Exception) {
            println("❌ Error descargando atletas: ${e.message}")
            Result.failure(e)
        }
    }
}