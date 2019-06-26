package edu.jrubiralta.portalbdn.presenter

import android.content.Context
import edu.jrubiralta.portalbdn.ui.view.View

interface BasePresenter<V> where V : View {
    fun init()
    fun resume()
    fun pause()
    fun stop()
    fun destroy()
    fun getContext(): Context
}
