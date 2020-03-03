package com.jrubiralta.data.network

import com.jrubiralta.data.model.*
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

    override fun getIncidencies(): Single<List<IncidenciesDto>> {
        return apiService.getIncidencies(
                "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVlNTgyZTQ1OWI0ZDYxMjMzYzA4MmE1ZSIsImVtYWlsIjoianJ1YmlyYWx0YUBnbWFpbC5jb20iLCJpYXQiOjE1ODI4MzczNTcsImV4cCI6MTU4MjkyMzc1N30.R0kk9m4R5DkmbmBcWcuTxuqrTqt91ZFZYhmShKDp2vA",
                IncidenciaRequestDto("5e582e459b4d61233c082a5e")
        )
    }
}