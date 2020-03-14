package com.jrubiralta.portalbdn.presenter.home

import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.ui.view.home.HomeView

class HomePresenterImpl(
        view: HomeView,
        persistence: Persistence)
    : BasePresenterImpl<HomeView>(view, persistence),
        HomePresenter {

    override fun moveDrawer() {
        view.moveDrawer()
    }

}