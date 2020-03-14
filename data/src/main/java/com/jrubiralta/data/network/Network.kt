package com.jrubiralta.data.network

import com.jrubiralta.data.model.*
import io.reactivex.Single


interface Network {

    fun signin(request: SigninDto): Single<UserDto>
    fun signup(request: SignupDto): Single<UserDto>
    fun getIncidencies(token: String, request: RequestDto): Single<List<IncidenciesDto>>
    fun addIncidencia(token: String, request: NewIncidenciaRequestDto): Single<Unit>
    fun answerPoll(token: String, request: AnswerPollRequestDto): Single<Unit>
    fun getPolls(token: String, request: RequestDto): Single<List<GetPollsResponseDto>>
    fun getEvents(token: String): Single<List<GetEventsResponseDto>>

}