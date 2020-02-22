package com.jrubiralta.portalbdn.ui.activity.login

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.Navigator.Navigator
import com.jrubiralta.portalbdn.Navigator.android.NavParams
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.login.LoginPresenter
import com.jrubiralta.portalbdn.presenter.login.LoginPresenterImpl
import com.jrubiralta.portalbdn.ui.activity.BaseActivity
import com.jrubiralta.portalbdn.ui.view.login.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity
    : BaseActivity<LoginPresenter, LoginView>(),
        LoginView {


    override val presenter: LoginPresenter by instance()

    override val layoutResourceId = R.layout.activity_login

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<LoginPresenter>() with provider {
            LoginPresenterImpl(
                    view = this@LoginActivity
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initView()
        initListeners()
        initData()
    }

    private fun initView() {
        setContentView(layoutResourceId)
    }

    private fun initListeners() {
        tv_register.setOnClickListener {
            Navigator.openRegisterPage(NavParams(this, false))
        }
        btn_login.setOnClickListener {
            Navigator.openHomePage(NavParams(this, true))
        }
    }

    private fun initData() {
    }

    override fun onBackPressed() {
    }

}