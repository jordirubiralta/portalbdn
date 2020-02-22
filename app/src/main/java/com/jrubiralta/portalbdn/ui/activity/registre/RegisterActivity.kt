package com.jrubiralta.portalbdn.ui.activity.registre

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
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenter
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenterImpl
import com.jrubiralta.portalbdn.ui.activity.BaseActivity
import com.jrubiralta.portalbdn.ui.view.login.LoginView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity
    : BaseActivity<RegisterPresenter, RegisterView>(),
        RegisterView {


    override val presenter: RegisterPresenter by instance()

    override val layoutResourceId = R.layout.activity_register

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<RegisterPresenter>() with provider {
            RegisterPresenterImpl(
                    view = this@RegisterActivity
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
        tv_do_login.setOnClickListener {
            Navigator.openLoginPage(NavParams(this, true))
        }
    }

    private fun initData() {
    }

    override fun onBackPressed() {
    }

}