package com.example.olimpicfantasy.domain.repository

import com.example.olimpicfantasy.domain.model.Atleta

interface FantasyRepository {
    suspend fun obtenerTodosLosAtletas(): Result<List<Atleta>>
}