package edu.jrubiralta.portalbdn.presenter

import android.app.Activity
import android.support.v4.app.Fragment
import edu.jrubiralta.portalbdn.persistence.Persistence
import edu.jrubiralta.portalbdn.ui.view.View

abstract class BasePresenterImpl<V>(
    protected val view: V)
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
}
