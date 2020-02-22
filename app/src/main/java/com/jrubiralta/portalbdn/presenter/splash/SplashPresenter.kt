package com.jrubiralta.portalbdn.presenter.splash

import com.jrubiralta.portalbdn.presenter.BasePresenter
import com.jrubiralta.portalbdn.ui.view.splash.SplashView

interface SplashPresenter
    : BasePresenter<SplashView> {

    fun getIncidencies()
}
