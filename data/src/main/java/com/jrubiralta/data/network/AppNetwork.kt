package com.jrubiralta.data.network

import com.jrubiralta.data.model.IncidenciesDto
import io.reactivex.Single

class AppNetwork(
    private val apiService: ApiService)
    : Network {

    override fun getIncidencies(): Single<List<IncidenciesDto>> {
        return apiService.getIncidencies()
    }
}