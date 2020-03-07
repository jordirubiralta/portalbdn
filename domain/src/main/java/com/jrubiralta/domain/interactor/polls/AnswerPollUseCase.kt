package com.jrubiralta.domain.interactor.polls

import com.jrubiralta.domain.repository.PollsRepository
import com.jrubiralta.portalbdn.domain.executor.Executor
import com.jrubiralta.portalbdn.domain.interactor.SingleInteractor


class AnswerPollUseCase(
        private val repository: PollsRepository,
        executor: Executor)
    : SingleInteractor<Unit>(executor = executor) {

    lateinit var pollId: String
    var answer: Boolean = false

    fun execute(pollId: String, answer: Boolean, onSuccess: (Unit) -> Unit, onError: (Throwable) -> Unit) {

        this.pollId = pollId
        this.answer = answer

        super.execute(onSuccess = onSuccess,
                onError = onError,
                single = repository.answerPoll(pollId, answer))
    }
}