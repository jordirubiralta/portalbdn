package com.jrubiralta.domain.interactor.events

import com.jrubiralta.domain.model.GetEventsResponseModel
import com.jrubiralta.domain.repository.EventsRepository
import com.jrubiralta.portalbdn.domain.executor.Executor
import com.jrubiralta.portalbdn.domain.interactor.SingleInteractor

class GetEventsUseCase(
        private val repository: EventsRepository,
        executor: Executor)
    : SingleInteractor<List<GetEventsResponseModel>>(executor = executor) {

    fun execute(onSuccess: (List<GetEventsResponseModel>) -> Unit, onError: (Throwable) -> Unit) {

        super.execute(onSuccess = onSuccess, onError = onError,
                single = repository.getEvents())
    }
}