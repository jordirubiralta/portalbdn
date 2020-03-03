package com.jrubiralta.portalbdn.ui.view.login

import com.jrubiralta.domain.model.User
import com.jrubiralta.portalbdn.ui.view.View

interface LoginView
    : View {

    fun loginSuccess(user: User)

}
