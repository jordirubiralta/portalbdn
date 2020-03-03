package com.jrubiralta.portalbdn.ui.view.registre

import com.jrubiralta.domain.model.User
import com.jrubiralta.portalbdn.ui.view.View

interface RegisterView
    : View {

    fun registerSuccess(user: User)

}
