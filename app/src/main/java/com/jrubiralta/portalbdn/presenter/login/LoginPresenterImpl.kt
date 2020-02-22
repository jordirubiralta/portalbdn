package com.jrubiralta.portalbdn.presenter.login

import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.ui.view.login.LoginView

class LoginPresenterImpl(
        view: LoginView)
    : BasePresenterImpl<LoginView>(view),
        LoginPresenter {
}
