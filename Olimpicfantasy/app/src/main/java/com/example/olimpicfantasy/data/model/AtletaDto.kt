package com.example.olimpicfantasy.data.model

import com.example.olimpicfantasy.domain.model.Atleta
import com.example.olimpicfantasy.domain.model.AtletaId
import com.example.olimpicfantasy.domain.model.DeporteId
import com.example.olimpicfantasy.domain.model.EstadoAtleta
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AtletaDto(
    @SerialName("id") val id: String,
    @SerialName("nombre") val nombre: String,
    @SerialName("deporte_id") val deporteId: String,
    @SerialName("foto_url") val fotoUrl: String? = null,
    @SerialName("precio") val precio: Long,
    @SerialName("estado") val estado: String
)

fun AtletaDto.toDomain(): Atleta {
    return Atleta(

        id = AtletaId(this.id),
        nombre = this.nombre,
        deporteId = DeporteId(this.deporteId),
        fotoUrl = this.fotoUrl,
        precio = this.precio,


        estado = try {

            EstadoAtleta.valueOf(this.estado)
        } catch (e: IllegalArgumentException) {

            EstadoAtleta.ELIMINADO
        }
    )
}