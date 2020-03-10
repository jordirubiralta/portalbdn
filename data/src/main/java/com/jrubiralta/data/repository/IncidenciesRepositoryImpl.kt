package com.jrubiralta.data.repository

import com.jrubiralta.data.mapper.toModel
import com.jrubiralta.data.model.RequestDto
import com.jrubiralta.data.model.NewIncidenciaRequestDto
import com.jrubiralta.data.network.Network
import com.jrubiralta.domain.repository.IncidenciesRepository
import com.jrubiralta.portalbdn.persistence.Persistence

class IncidenciesRepositoryImpl(
    private val network: Network,
    private val persistence: Persistence)
    : IncidenciesRepository {


    override fun getIncidencies() =
        network.getIncidencies(persistence.getAccessToken(),
                RequestDto(persistence.getUser().id!!))
                .map { it.map { it.toModel() } }

    override fun addIncidencia(title: String, description: String, location: String) =
        network.addIncidencia(persistence.getAccessToken(),
                NewIncidenciaRequestDto(
                        userId = persistence.getUser().id!!,
                        title = title,
                        description = description,
                        location = location))
}