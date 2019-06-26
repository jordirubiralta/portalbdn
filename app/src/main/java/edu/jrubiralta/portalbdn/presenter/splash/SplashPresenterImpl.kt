package com.enel.edist.presenter.splash

import edu.jrubiralta.portalbdn.persistence.Persistence
import edu.jrubiralta.portalbdn.presenter.BasePresenterImpl
import edu.jrubiralta.portalbdn.presenter.splash.SplashPresenter
import edu.jrubiralta.portalbdn.ui.view.Splash.SplashView
import io.reactivex.disposables.Disposable

class SplashPresenterImpl(
    view: SplashView)
    : BasePresenterImpl<SplashView>(view),
    SplashPresenter {

    companion object {
        const val TIME_WAIT: Long = 500
    }

    private var subscribe: Disposable? = null

    override fun pause() {
        super.pause()
        subscribe?.dispose()
    }

    override fun destroy() {
        super.destroy()
    }
}
