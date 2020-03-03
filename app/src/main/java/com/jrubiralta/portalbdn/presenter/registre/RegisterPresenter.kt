package com.jrubiralta.portalbdn.presenter.registre

import com.jrubiralta.portalbdn.presenter.BasePresenter
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView
import com.jrubiralta.portalbdn.ui.view.splash.SplashView


interface RegisterPresenter
    : BasePresenter<RegisterView> {

    fun signup(email: String, password: String, name: String, surname: String, age: Int)
}
