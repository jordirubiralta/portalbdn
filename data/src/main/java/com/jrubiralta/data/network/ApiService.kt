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
    @POST("getIncidencies")
    fun getIncidencies(@Header("Authorization") auth: String,
                       @Body user_id: RequestDto): Single<List<IncidenciesDto>>

    @Headers("Content-Type: application/json")
    @POST("addIncidencia")
    fun addIncidencia(@Header("Authorization") auth: String,
                       @Body user_id: NewIncidenciaRequestDto): Single<Unit>

    @Headers("Content-Type: application/json")
    @POST("answerPoll")
    fun answerPoll(@Header("Authorization") auth: String,
                       @Body user_id: AnswerPollRequestDto): Single<Unit>

    @Headers("Content-Type: application/json")
    @POST("getPolls")
    fun getPolls(@Header("Authorization") auth: String,
                      @Body user_id: RequestDto): Single<List<GetPollsResponseDto>>
}