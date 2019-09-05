package edu.jrubiralta.portalbdn.presenter.home

import edu.jrubiralta.portalbdn.presenter.BasePresenter
import edu.jrubiralta.portalbdn.ui.view.home.HomeView

interface HomePresenter
    : BasePresenter<HomeView> {

    fun moveDrawer()

}