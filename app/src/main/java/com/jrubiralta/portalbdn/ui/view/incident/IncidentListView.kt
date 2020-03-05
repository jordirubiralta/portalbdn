package com.jrubiralta.portalbdn.ui.view.incident

import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.portalbdn.ui.view.View

interface IncidentListView
    : View {

    fun showIncidents(IncidentsList: List<Incidencia>)


}
