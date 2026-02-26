package com.example.olimpicfantasy.domain.usecase
import com.example.olimpicfantasy.domain.model.Estadisticas

class CalcularPuntosUseCase {


    operator fun invoke(estadisticas: Estadisticas): Int {

        val puntosPorOro = estadisticas.oros * 50
        val puntosPorPlata = estadisticas.platas * 30
        val puntosPorBronce = estadisticas.bronces * 15
        val puntosPorParticipar = estadisticas.participaciones * 5
        val puntosPorRecord = estadisticas.recordsMundiales * 20


        return puntosPorOro + puntosPorPlata + puntosPorBronce + puntosPorParticipar + puntosPorRecord
    }
}