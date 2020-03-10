package com.jrubiralta.portalbdn.presenter.login

import android.util.Log
import com.jrubiralta.domain.interactor.incidencies.GetIncidenciesUseCase
import com.jrubiralta.domain.interactor.user.SignInUseCase
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.ui.view.login.LoginView

class LoginPresenterImpl(
        view: LoginView,
        persistence: Persistence,
        private val signInUseCase: SignInUseCase)
    : BasePresenterImpl<LoginView>(view, persistence),
        LoginPresenter {

    override fun signin(email: String, password: String) {
        executeSignin(email, password)
    }

    private fun executeSignin(email: String, password: String) {
        signInUseCase.execute(email, password,
                onSuccess = {
                    it.token?.let { token ->
                        persistence.setAccessToken(token)
                    }
                    it.newspaper?.let { newspaper ->
                        persistence.setNewspaper(newspaper)
                    }
                    persistence.setUser(it)
                    view.loginSuccess(it)
                    Log.d("SUCCESS", it.toString())
                },
                onError = {
                    view.printErrorMessage(it.message)
                    view.loginError(username = true, password = true)
                }
        )
    }
}
