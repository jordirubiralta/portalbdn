package com.jrubiralta.portalbdn.ui.activity.login

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.domain.model.User
import com.jrubiralta.portalbdn.Navigator.Navigator
import com.jrubiralta.portalbdn.Navigator.android.NavParams
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.login.LoginPresenter
import com.jrubiralta.portalbdn.presenter.login.LoginPresenterImpl
import com.jrubiralta.portalbdn.ui.activity.BaseActivity
import com.jrubiralta.portalbdn.ui.view.login.LoginView
import com.jrubiralta.portalbdn.utils.visible
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity
    : BaseActivity<LoginPresenter, LoginView>(),
        LoginView {


    override val presenter: LoginPresenter by instance()

    override val layoutResourceId = R.layout.activity_login

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<LoginPresenter>() with provider {
            LoginPresenterImpl(
                    view = this@LoginActivity,
                    persistence = instance(),
                    signInUseCase = instance()
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
            var username = et_username.text.toString()
            var password = et_password.text.toString()
            if (!username.isNullOrEmpty() && !password.isNullOrEmpty())
                presenter.signin(username, password)
            else {
                tv_error.apply {
                    this.visible()
                    text = getString(R.string.error_message)
                }
                loginError(username.isNullOrEmpty(), password.isNullOrEmpty())
            }
        }
    }

    private fun initData() {
    }

    override fun onBackPressed() {
    }

    override fun loginSuccess(user: User) {
        Navigator.openHomePage(NavParams(this, true))
    }

    override fun loginError(username: Boolean, password: Boolean) {
        if (username) {
            ll_username.background = getDrawable(R.drawable.zz_edittext_wrong)
            iv_username.setColorFilter(ContextCompat.getColor(getCtx(), R.color.red))
        } else {
            ll_password.background = getDrawable(R.drawable.zz_edittext_background)
            iv_password.setColorFilter(ContextCompat.getColor(getCtx(), R.color.colorPrimary))
        }
        if (password) {
            ll_password.background = getDrawable(R.drawable.zz_edittext_wrong)
            iv_password.setColorFilter(ContextCompat.getColor(getCtx(), R.color.red))
        }  else {
            ll_password.background = getDrawable(R.drawable.zz_edittext_background)
            iv_password.setColorFilter(ContextCompat.getColor(getCtx(), R.color.colorPrimary))
        }
    }

    override fun printErrorMessage(error: String?) {
        error?.let { message ->
            tv_error.apply {
                this.visible()
                text = message
            }
        }
    }
}