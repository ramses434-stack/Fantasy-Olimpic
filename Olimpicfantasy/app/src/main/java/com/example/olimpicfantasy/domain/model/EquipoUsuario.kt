package com.example.olimpicfantasy.domain.model


import kotlinx.serialization.Serializable

@Serializable
data class EquipoUsuario(
    val id: EquipoId,
    val userId: UserID,
    val nombreEquipo: String,
    val atletas: List<Atleta>,
    val presupuestoRestante: Long,
    val puntosTotales: Int = 0
)