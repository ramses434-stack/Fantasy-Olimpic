package com.example.olimpicfantasy.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Estadisticas(
    val oros: Int = 0,
    val platas: Int = 0,
    val bronces: Int = 0,
    val participaciones: Int = 0,
    val recordsMundiales: Int = 0,

    ) {



}