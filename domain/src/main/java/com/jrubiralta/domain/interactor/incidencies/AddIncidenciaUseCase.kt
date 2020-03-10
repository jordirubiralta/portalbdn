package com.jrubiralta.domain.interactor.incidencies

import com.jrubiralta.domain.repository.IncidenciesRepository
import com.jrubiralta.portalbdn.domain.executor.Executor
import com.jrubiralta.portalbdn.domain.interactor.SingleInteractor

class AddIncidenciaUseCase(
        private val repository: IncidenciesRepository,
        executor: Executor)
    : SingleInteractor<Unit>(executor = executor) {

    lateinit var title: String
    lateinit var description: String
    lateinit var location: String

    fun execute(title: String, description: String, location: String,
                onSuccess: (Unit) -> Unit, onError: (Throwable) -> Unit) {

        this.title = title
        this.description = description
        this.location = location

        super.execute(onSuccess = onSuccess, onError = onError,
                single = repository.addIncidencia(title = title, description = description, location = location))
    }
}