package com.jrubiralta.data.network

import com.jrubiralta.data.model.*
import io.reactivex.Single


interface Network {

    fun signin(request: SigninDto) : Single<UserDto>
    fun signup(request: SignupDto) : Single<UserDto>
    fun getIncidencies(token: String, request: IncidenciaRequestDto) : Single<List<IncidenciesDto>>

}