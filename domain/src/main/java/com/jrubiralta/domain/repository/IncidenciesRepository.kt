package com.jrubiralta.domain.repository

import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.domain.model.User
import io.reactivex.Single

interface IncidenciesRepository {
    fun getIncidencies(): Single<List<Incidencia>>
}