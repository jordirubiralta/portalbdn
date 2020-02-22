package com.jrubiralta.data.repository

import com.jrubiralta.data.mapper.toModel
import com.jrubiralta.data.network.Network
import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.domain.repository.IncidenciesRepository
import io.reactivex.Single

class IncidenciesRepositoryImpl(
    private val network: Network
)
    : IncidenciesRepository {

    override fun getIncidencies(): Single<List<Incidencia>> =
        network.getIncidencies().map { it.map { it.toModel() } }
}