package com.jrubiralta.data.repository

import com.jrubiralta.data.mapper.toModel
import com.jrubiralta.data.model.IncidenciaRequestDto
import com.jrubiralta.data.model.NewIncidenciaRequestDto
import com.jrubiralta.data.model.SigninDto
import com.jrubiralta.data.network.Network
import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.domain.model.User
import com.jrubiralta.domain.repository.IncidenciesRepository
import com.jrubiralta.portalbdn.persistence.Persistence
import io.reactivex.Single

class IncidenciesRepositoryImpl(
    private val network: Network,
    private val persistence: Persistence)
    : IncidenciesRepository {


    override fun getIncidencies() =
        network.getIncidencies(persistence.getAccessToken(),
                IncidenciaRequestDto(persistence.getUser().id!!))
                .map { it.map { it.toModel() } }

    override fun addIncidencia(title: String, description: String, location: String) =
        network.addIncidencia(persistence.getAccessToken(),
                NewIncidenciaRequestDto(
                        userId = persistence.getUser().id!!,
                        title = title,
                        description = description,
                        location = location))
}