package com.jrubiralta.portalbdn.presenter.login

import com.jrubiralta.portalbdn.presenter.BasePresenter
import com.jrubiralta.portalbdn.ui.view.login.LoginView

interface LoginPresenter
    : BasePresenter<LoginView> {

    fun signin(email: String, password: String)
}
