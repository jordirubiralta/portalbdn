package com.jrubiralta.portalbdn.presenter.incident

import com.jrubiralta.domain.interactor.incidencies.GetIncidenciesUseCase
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenter
import com.jrubiralta.portalbdn.ui.view.incident.IncidentListView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView

class IncidentListPresenterImpl(
        view: IncidentListView,
        persistence: Persistence,
        private val getIncidenciesUseCase: GetIncidenciesUseCase)
    : BasePresenterImpl<IncidentListView>(view, persistence),
        IncidentListPresenter {

    override fun resume() {
        super.init()
        getIncidents()
    }

    private fun getIncidents() {
        getIncidenciesUseCase.execute(
                onSuccess = {
                    view.showIncidents(it)
                },
                onError = {
                    // TO DO DIALOG FOR ERROR
                }
        )
    }
}
