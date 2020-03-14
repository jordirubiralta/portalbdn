package com.jrubiralta.data.repository

import com.jrubiralta.data.mapper.toModel
import com.jrubiralta.data.model.AnswerPollRequestDto
import com.jrubiralta.data.model.RequestDto
import com.jrubiralta.data.network.Network
import com.jrubiralta.domain.repository.PollsRepository
import com.jrubiralta.portalbdn.persistence.Persistence

class PollsRepositoryImpl(
        private val network: Network,
        private val persistence: Persistence)
    : PollsRepository {

    override fun answerPoll(pollId: String, answer: Boolean) =
            network.answerPoll(persistence.getAccessToken(),
                    AnswerPollRequestDto(persistence.getUser().id!!, pollId, answer))

    override fun getPolls() =
            network.getPolls(persistence.getAccessToken(),
                    RequestDto(persistence.getUser().id!!))
                    .map { it.map { it.toModel() } }
}