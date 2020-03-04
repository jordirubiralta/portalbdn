package com.jrubiralta.data.network

import com.jrubiralta.data.model.*
import com.jrubiralta.portalbdn.persistence.Persistence
import io.reactivex.Single

class AppNetwork(
        private val apiService: ApiService)
    : Network {

    override fun signin(request: SigninDto): Single<UserDto> {
        return apiService.signin(request)
    }

    override fun signup(request: SignupDto): Single<UserDto> {
        return apiService.signup(request)
    }

    override fun getIncidencies(token: String, request: IncidenciaRequestDto): Single<List<IncidenciesDto>> {
        return apiService.getIncidencies(token, request)
    }
}