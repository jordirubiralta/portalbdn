package com.jrubiralta.data.network

import com.jrubiralta.data.model.*
import io.reactivex.Single

class AppNetwork(
        private val apiService: ApiService)
    : Network {

    override fun signin(request: SigninDto) =
            apiService.signin(request)

    override fun signup(request: SignupDto) =
            apiService.signup(request)

    override fun getIncidencies(token: String, request: RequestDto) =
            apiService.getIncidencies(token, request)

    override fun addIncidencia(token: String, request: NewIncidenciaRequestDto) =
            apiService.addIncidencia(token, request)

    override fun answerPoll(token: String, request: AnswerPollRequestDto): Single<Unit> =
            apiService.answerPoll(token, request)

    override fun getPolls(token: String, request: RequestDto): Single<List<GetPollsResponseDto>> =
            apiService.getPolls(token, request)

    override fun getEvents(token: String): Single<List<GetEventsResponseDto>> =
            apiService.getEvents(token)

}