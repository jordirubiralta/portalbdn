package com.jrubiralta.data.mapper

import com.jrubiralta.data.model.IncidenciesDto
import com.jrubiralta.data.model.UserDto
import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.domain.model.User
import com.jrubiralta.portalbdn.domain.constants.Constants

fun UserDto.toModel() = User(
        id = id,
        token = token,
        email = email,
        age = age,
        name = name,
        surname = surname)

fun IncidenciesDto.toModel(): Incidencia =
        Incidencia(
                id = id,
                userId = userId,
                titol = titol ?: Constants.EMPTY_STRING,
                descripcio = descripcio ?: Constants.EMPTY_STRING,
                data = data ?: Constants.EMPTY_STRING,
                ubicacio = ubicacio ?: Constants.EMPTY_STRING,
                resolt = resolt ?: false)

