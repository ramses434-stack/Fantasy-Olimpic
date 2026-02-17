package com.example.olimpicfantasy.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Atleta(
    val atletaID: AtletaID,
    val nombre: String,


    val deporteId: DeporteId,
    val fotoUrl: String?,

    val precio: Long,
    val estado: EstadoAtleta
) {

    init {
        require(precio >= 0) { "El precio no puede ser negativo" }
        if (fotoUrl != null) {
            require(fotoUrl.startsWith("http")) { "La URL de la foto debe ser válida" }
        }
    }
    enum class EstadoAtleta{
        Activo,
        Lesionado,
        Dudoso,
        eliminado
    }


}