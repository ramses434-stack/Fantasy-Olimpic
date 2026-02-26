package com.example.olimpicfantasy.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class EstadisticasDto(
    @SerialName("oros") val oros: Int = 0,
    @SerialName("platas") val platas: Int = 0,
    @SerialName("bronces") val bronces: Int = 0,
    @SerialName("participaciones") val participaciones: Int = 0,
    @SerialName("records_mundiales") val recordsMundiales: Int = 0
)


@Serializable
data class EquipoUsuarioDto(
    @SerialName("id") val id: String,
    @SerialName("user_id") val userId: String,
    @SerialName("nombre_equipo") val nombreEquipo: String,
    @SerialName("presupuesto_restante") val presupuestoRestante: Long,
    @SerialName("puntos_totales") val puntosTotales: Int
)