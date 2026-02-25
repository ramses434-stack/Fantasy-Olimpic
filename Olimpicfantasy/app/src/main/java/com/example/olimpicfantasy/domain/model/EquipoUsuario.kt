package com.example.olimpicfantasy.domain.model

data class EquipoUsuario(
    val id: EquipoId,
    val userID: UserID,
    val nombreEquipo: String,
    val atletas: List<Atleta>,
    val presupuestoRestante: Long,
    val puntosTotales: Int = 0
)