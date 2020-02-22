package com.jrubiralta.portalbdn.presenter.home

import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.ui.view.home.HomeView

class HomePresenterImpl(
        view: HomeView)
    : BasePresenterImpl<HomeView>(view),
        HomePresenter {

    override fun moveDrawer() {
        view.moveDrawer()
    }

}