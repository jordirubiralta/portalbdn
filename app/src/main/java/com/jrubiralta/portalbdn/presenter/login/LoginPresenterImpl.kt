package com.jrubiralta.portalbdn.presenter.login

import android.util.Log
import com.jrubiralta.domain.interactor.incidencies.GetIncidenciesUseCase
import com.jrubiralta.domain.interactor.user.SignInUseCase
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.ui.view.login.LoginView

class LoginPresenterImpl(
        view: LoginView,
        private val signInUseCase: SignInUseCase)
    : BasePresenterImpl<LoginView>(view),
        LoginPresenter {

    override fun signin(email: String, password: String) {
        executeSignin(email, password)
    }

    private fun executeSignin(email: String, password: String) {
        signInUseCase.execute(email, password,
                onSuccess = {
                    view.loginSuccess(it)
                    Log.d("SUCCESS", it.toString())
                },
                onError = {
                    Log.d("ERROR", it.toString())
                }
        )
    }
}
