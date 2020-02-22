package com.jrubiralta.data.network

import com.jrubiralta.data.model.IncidenciesDto
import io.reactivex.Single


interface Network {

    fun getIncidencies() : Single<List<IncidenciesDto>>
}