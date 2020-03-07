package com.jrubiralta.domain.repository

import com.jrubiralta.domain.model.GetPollsResponseModel
import io.reactivex.Single


interface PollsRepository {
    fun answerPoll(pollId: String, answer: Boolean): Single<Unit>
    fun getPolls(): Single<List<GetPollsResponseModel>>
}