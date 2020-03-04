package com.jrubiralta.portalbdn.presenter.home

import com.jrubiralta.portalbdn.presenter.BasePresenter
import com.jrubiralta.portalbdn.ui.view.home.HomeView

interface HomePresenter
    : BasePresenter<HomeView> {

    fun moveDrawer()
    fun getData()
}