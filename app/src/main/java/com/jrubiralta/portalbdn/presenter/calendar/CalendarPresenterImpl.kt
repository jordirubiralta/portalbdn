package com.jrubiralta.portalbdn.presenter.calendar

import com.jrubiralta.domain.interactor.events.GetEventsUseCase
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.incident.IncidentListPresenter
import com.jrubiralta.portalbdn.ui.view.calendar.CalendarView
import com.jrubiralta.portalbdn.ui.view.incident.IncidentListView

class CalendarPresenterImpl(
        view: CalendarView,
        persistence: Persistence,
        private val getEventsUseCase: GetEventsUseCase)
    : BasePresenterImpl<CalendarView>(view, persistence),
        CalendarPresenter {

    override fun init() {
        super.init()
        getEvents()
    }

    private fun getEvents() {
        getEventsUseCase.execute(
                onSuccess = {
                    view.showEvents(it)
                },
                onError = {
                    // TO DO DIALOG FOR ERROR
                }
        )
    }

}
