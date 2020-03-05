package com.jrubiralta.portalbdn.presenter.incident

import com.jrubiralta.domain.interactor.incidencies.AddIncidenciaUseCase
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.news.NewsPresenter
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenter
import com.jrubiralta.portalbdn.ui.view.incident.NewIncidentView
import com.jrubiralta.portalbdn.ui.view.news.NewsView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView

class NewIncidentPresenterImpl(
        view: NewIncidentView,
        persistence: Persistence,
        private val addIncidenciaUseCase: AddIncidenciaUseCase)
    : BasePresenterImpl<NewIncidentView>(view, persistence),
        NewIncidentPresenter {

    override fun addIncident(title: String, description: String, location: String) {
        executeAddIncident(title, description, location)
    }

    private fun executeAddIncident(title: String, description: String, location: String) {
        addIncidenciaUseCase.execute(title, description, description,
                onSuccess = {
                    view.navigateToList()
                },
                onError = {
                    // GESTIONAR ERRORS
                }
        )
    }

}
