package com.jrubiralta.data.network

import com.jrubiralta.data.model.*
import com.jrubiralta.portalbdn.persistence.Persistence
import io.reactivex.Single

class AppNetwork(
        private val apiService: ApiService)
    : Network {

    override fun signin(request: SigninDto) =
            apiService.signin(request)

    override fun signup(request: SignupDto) =
            apiService.signup(request)

    override fun getIncidencies(token: String, request: IncidenciaRequestDto) =
            apiService.getIncidencies(token, request)

    override fun addIncidencia(token: String, request: NewIncidenciaRequestDto) =
            apiService.addIncidencia(token, request)


}