package com.jrubiralta.data.network

import com.jrubiralta.data.model.IncidenciesDto
import com.jrubiralta.data.model.SigninDto
import com.jrubiralta.data.model.SignupDto
import com.jrubiralta.data.model.UserDto
import io.reactivex.Single


interface Network {

    fun signin(request: SigninDto) : Single<UserDto>
    fun signup(request: SignupDto) : Single<UserDto>
    fun getIncidencies() : Single<List<IncidenciesDto>>

}