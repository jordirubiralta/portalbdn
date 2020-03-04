package com.jrubiralta.portalbdn.presenter.incident

import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenter
import com.jrubiralta.portalbdn.ui.view.incident.IncidentListView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView

class IncidentListPresenterImpl(
        view: IncidentListView,
        persistence: Persistence)
    : BasePresenterImpl<IncidentListView>(view, persistence),
        IncidentListPresenter {
}
