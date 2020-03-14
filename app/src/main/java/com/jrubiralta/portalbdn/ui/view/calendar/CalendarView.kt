package com.jrubiralta.portalbdn.ui.view.calendar

import com.jrubiralta.domain.model.GetEventsResponseModel
import com.jrubiralta.portalbdn.ui.view.View

interface CalendarView
    : View {

    fun showEvents(eventsList: List<GetEventsResponseModel>)

}
