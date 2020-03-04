package com.jrubiralta.portalbdn.presenter.incident

import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.news.NewsPresenter
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenter
import com.jrubiralta.portalbdn.ui.view.incident.NewIncidentView
import com.jrubiralta.portalbdn.ui.view.news.NewsView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView

class NewIncidentPresenterImpl(
        view: NewIncidentView,
        persistence: Persistence)
    : BasePresenterImpl<NewIncidentView>(view, persistence),
        NewIncidentPresenter {
}
