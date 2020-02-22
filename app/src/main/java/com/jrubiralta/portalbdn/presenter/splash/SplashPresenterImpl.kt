package com.enel.edist.presenter.splash

import android.util.Log
import com.jrubiralta.domain.interactor.incidencies.GetIncidenciesUseCase
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.splash.SplashPresenter
import com.jrubiralta.portalbdn.ui.view.splash.SplashView

class SplashPresenterImpl(
        view: SplashView,
        private val getIncidenciesUseCase: GetIncidenciesUseCase)
    : BasePresenterImpl<SplashView>(view),
        SplashPresenter {

    override fun getIncidencies() {
        executeGetIncidencies()
    }

    private fun executeGetIncidencies() {
        getIncidenciesUseCase.execute(
                onSuccess = {
                    Log.d("SUCCESS", it.toString())
                },
                onError = {
                    Log.d("ERROR", it.toString())
                }
        )
    }
}
