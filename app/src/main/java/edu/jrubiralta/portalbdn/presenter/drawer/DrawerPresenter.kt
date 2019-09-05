package edu.jrubiralta.portalbdn.presenter.drawer

import edu.jrubiralta.portalbdn.presenter.BasePresenter
import edu.jrubiralta.portalbdn.ui.view.fragments.DrawerView

interface DrawerPresenter
    : BasePresenter<DrawerView> {

    fun onViewStart()

}
