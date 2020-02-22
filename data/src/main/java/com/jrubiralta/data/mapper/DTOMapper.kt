package com.jrubiralta.data.mapper

import com.jrubiralta.data.model.IncidenciesDto
import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.portalbdn.domain.constants.Constants

fun IncidenciesDto.toModel(): Incidencia =
        Incidencia(
                titol = titol ?: Constants.EMPTY_STRING,
                descripcio = descripcio ?: Constants.EMPTY_STRING,
                data = data ?: Constants.EMPTY_STRING,
                hora = hora ?: Constants.EMPTY_STRING,
                ubicacio = ubicacio ?: Constants.EMPTY_STRING,
                resolt = resolt ?: false)


