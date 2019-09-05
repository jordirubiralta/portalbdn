package edu.jrubiralta.portalbdn.presenter.drawer

import edu.jrubiralta.portalbdn.presenter.BasePresenterImpl
import edu.jrubiralta.portalbdn.ui.view.fragments.DrawerView

class DrawerPresenterImpl(
    view: DrawerView)
    : BasePresenterImpl<DrawerView>(view),
    DrawerPresenter {

    override fun onViewStart() {
        view.onViewStart()
    }

}