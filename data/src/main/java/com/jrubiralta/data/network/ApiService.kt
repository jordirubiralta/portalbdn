package com.jrubiralta.data.network

import com.jrubiralta.data.model.IncidenciesDto
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    companion object {
        val ENDPOINT_1 = "http://192.168.1.106:8081/"
    }

    @GET("getIncidents")
    fun getIncidencies(): Single<List<IncidenciesDto>>
}