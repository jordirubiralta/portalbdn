package com.jrubiralta.portalbdn.presenter

import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.ui.view.View

abstract class BasePresenterImpl<V>(
    protected val view: V,
    protected val persistence: Persistence)
    : BasePresenter<V> where V : View {

    override fun init() {
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun stop() {
    }

    override fun destroy() {
    }

    override fun getContext() = view.getCtx()

    fun logout() {
        persistence.removeAccessToken()
        persistence.removeUser()
    }
}
