package com.jrubiralta.data.network

import com.jrubiralta.data.model.*
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {

    companion object {
        val ENDPOINT_1 = "http://192.168.1.106:3000/"
    }

    @Headers("Content-Type: application/json")
    @POST("signin")
    fun signin(@Body request: SigninDto): Single<UserDto>

    @Headers("Content-Type: application/json")
    @POST("signup")
    fun signup(@Body request: SignupDto): Single<UserDto>

    @Headers("Content-Type: application/json")
    @POST("incidencies")
    fun getIncidencies(@Header("Authorization") auth: String,
                       @Body user_id: IncidenciaRequestDto): Single<List<IncidenciesDto>>
}