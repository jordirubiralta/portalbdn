package com.jrubiralta.domain.interactor.incidencies

import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.domain.repository.IncidenciesRepository
import com.jrubiralta.portalbdn.domain.executor.Executor
import com.jrubiralta.portalbdn.domain.interactor.SingleInteractor

class GetIncidenciesUseCase(
        private val repository: IncidenciesRepository,
        executor: Executor)
    : SingleInteractor<List<Incidencia>>(executor = executor) {

    fun execute(onSuccess: (List<Incidencia>) -> Unit, onError: (Throwable) -> Unit) {
        super.execute(onSuccess = onSuccess, onError = onError, single = repository.getIncidencies())
    }
}