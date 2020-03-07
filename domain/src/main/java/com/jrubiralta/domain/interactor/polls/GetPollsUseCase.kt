package com.jrubiralta.domain.interactor.polls

import com.jrubiralta.domain.model.GetPollsResponseModel
import com.jrubiralta.domain.repository.PollsRepository
import com.jrubiralta.portalbdn.domain.executor.Executor
import com.jrubiralta.portalbdn.domain.interactor.SingleInteractor

class GetPollsUseCase(
        private val repository: PollsRepository,
        executor: Executor)
    : SingleInteractor<List<GetPollsResponseModel>>(executor = executor) {

    fun execute(onSuccess: (List<GetPollsResponseModel>) -> Unit, onError: (Throwable) -> Unit) {
        super.execute(onSuccess = onSuccess, onError = onError, single = repository.getPolls())
    }
}