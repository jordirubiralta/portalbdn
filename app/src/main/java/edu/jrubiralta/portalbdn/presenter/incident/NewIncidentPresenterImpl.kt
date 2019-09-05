package edu.jrubiralta.portalbdn.presenter.incident

import edu.jrubiralta.portalbdn.presenter.BasePresenterImpl
import edu.jrubiralta.portalbdn.ui.view.incident.NewIncidentView

class NewIncidentPresenterImpl(
    view: NewIncidentView
)
    : BasePresenterImpl<NewIncidentView>(view),
    NewIncidentPresenter {

}