package com.jrubiralta.portalbdn.presenter

import android.content.Context
import com.jrubiralta.portalbdn.ui.view.View

interface BasePresenter<V> where V : View {
    fun init()
    fun resume()
    fun pause()
    fun stop()
    fun destroy()
    fun getContext(): Context
    fun logout()
}
