package com.enel.edist.presenter.splash

import android.os.Handler
import android.util.Log
import com.jrubiralta.domain.interactor.incidencies.GetIncidenciesUseCase
import com.jrubiralta.domain.interactor.user.SignInUseCase
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.splash.SplashPresenter
import com.jrubiralta.portalbdn.ui.view.splash.SplashView

class SplashPresenterImpl(
        view: SplashView,
        persistence: Persistence)
    : BasePresenterImpl<SplashView>(view, persistence),
        SplashPresenter {

    override fun init() {
        val handler = Handler()
        handler.postDelayed( {
            checkIfAccessTokenIsValid()
        }, 2000)
    }

    private fun checkIfAccessTokenIsValid() {
        if (persistence.hasAccessToken()) {
            view.navigateToHome()
        } else {
            view.navigateToLogin()
        }
    }
}
