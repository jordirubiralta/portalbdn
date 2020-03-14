package com.jrubiralta.data.mapper

import com.jrubiralta.data.model.GetEventsResponseDto
import com.jrubiralta.data.model.GetPollsResponseDto
import com.jrubiralta.data.model.IncidenciesDto
import com.jrubiralta.data.model.UserDto
import com.jrubiralta.domain.model.GetEventsResponseModel
import com.jrubiralta.domain.model.GetPollsResponseModel
import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.domain.model.User
import com.jrubiralta.portalbdn.domain.constants.Constants

fun UserDto.toModel() = User(
        id = id,
        token = token,
        email = email,
        age = age,
        name = name,
        surname = surname,
        newspaper = newspaper)

fun IncidenciesDto.toModel(): Incidencia =
        Incidencia(
                id = id,
                userId = userId,
                titol = titol ?: Constants.EMPTY_STRING,
                descripcio = descripcio ?: Constants.EMPTY_STRING,
                data = data,
                ubicacio = ubicacio ?: Constants.EMPTY_STRING,
                resolt = resolt ?: false)

fun GetPollsResponseDto.toModel(): GetPollsResponseModel =
        GetPollsResponseModel(
                pollId = pollId,
                question = question,
                answer = answer)

fun GetEventsResponseDto.toModel(): GetEventsResponseModel =
        GetEventsResponseModel(
                title = title,
                description = description,
                date = date,
                img = img,
                location = location,
                organizator = organizator)