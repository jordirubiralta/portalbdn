package com.jrubiralta.portalbdn.presenter.calendar

import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.incident.IncidentListPresenter
import com.jrubiralta.portalbdn.ui.view.calendar.CalendarView
import com.jrubiralta.portalbdn.ui.view.incident.IncidentListView

class CalendarPresenterImpl(
        view: CalendarView,
        persistence: Persistence)
    : BasePresenterImpl<CalendarView>(view, persistence),
        CalendarPresenter {
}
