package com.example.olimpicfantasy.domain.model

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class AtletaId(val value: Int)

@JvmInline
@Serializable
value class DeporteId(val value: Int)

@JvmInline
@Serializable
value class UserID(val value: String)

@JvmInline
@Serializable
value class LigaID(val value: Int)

@JvmInline
value class EquipoId(val value: String)