package com.jrubiralta.portalbdn.presenter.registre

import android.util.Log
import com.jrubiralta.domain.interactor.user.SignUpUseCase
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView

class RegisterPresenterImpl(
        view: RegisterView,
        persistence: Persistence,
        private val signUpUseCase: SignUpUseCase)
    : BasePresenterImpl<RegisterView>(view, persistence),
        RegisterPresenter {


    override fun signup(email: String, password: String, name: String, surname: String, age: Int, newspaper: String) {
        executeSignup(email, password, name, surname, age, newspaper)
    }

    private fun executeSignup(email: String, password: String, name: String, surname: String, age: Int, newspaper: String) {
        signUpUseCase.execute(email, password, name, surname, age, newspaper,
                onSuccess = {
                    it.token?.let { token ->
                        persistence.setAccessToken(token)
                    }
                    it.newspaper?.let { newspaper ->
                        persistence.setNewspaper(newspaper)
                    }
                    persistence.setUser(it)
                    view.registerSuccess(it)
                    Log.d("SUCCESS", it.toString())
                },
                onError = {}
        )
    }
}
