package com.jrubiralta.portalbdn.ui.activity.registre

import android.os.Bundle
import android.view.View
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
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenter
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenterImpl
import com.jrubiralta.portalbdn.ui.activity.BaseActivity
import com.jrubiralta.portalbdn.ui.view.login.LoginView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView
import com.jrubiralta.portalbdn.utils.visible
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.et_password
import kotlinx.android.synthetic.main.activity_register.ll_password
import kotlinx.android.synthetic.main.activity_register.ll_username
import kotlinx.android.synthetic.main.activity_register.tv_error

class RegisterActivity
    : BaseActivity<RegisterPresenter, RegisterView>(),
        RegisterView {


    override val presenter: RegisterPresenter by instance()

    override val layoutResourceId = R.layout.activity_register

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<RegisterPresenter>() with provider {
            RegisterPresenterImpl(
                    view = this@RegisterActivity,
                    signUpUseCase = instance()
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
        btn_register.setOnClickListener {
            var name = et_name.text.toString()
            var surname = et_surname.text.toString()
            var email = et_mail.text.toString()
            var emailRepeat = et_mail_repeat.text.toString()
            var age = et_age.text.toString().toInt()
            var password = et_password.text.toString()
            if (!name.isNullOrEmpty() && !surname.isNullOrEmpty() && !email.isNullOrEmpty() &&
                    !emailRepeat.isNullOrEmpty() && age != null && !password.isNullOrEmpty() &&
                    email == emailRepeat) {
                presenter.signup(email, password, name, surname, age)
            } else if (email != emailRepeat) {
                ll_mail.background = getDrawable(R.drawable.zz_edittext_wrong)
                ll_mail_repeat.background = getDrawable(R.drawable.zz_edittext_wrong)
                tv_error.apply {
                    this.visible()
                    text = getString(R.string.error_repeat_mail)
                }
            } else {
                tv_error.apply {
                    this.visible()
                    text = getString(R.string.error_message)
                }
                registerError(name.isNullOrEmpty(), surname.isNullOrEmpty(), email.isNullOrEmpty(),
                        emailRepeat.isNullOrEmpty(), password.isNullOrEmpty(), age == null)
            }
        }
    }

    private fun initData() {
    }

    private fun registerError(name: Boolean, surname: Boolean, email: Boolean, emailRepeat: Boolean,
                              password: Boolean, age: Boolean) {
        if (name) {
            ll_username.background = getDrawable(R.drawable.zz_edittext_wrong)
        } else {
            ll_username.background = getDrawable(R.drawable.zz_edittext_background)
        }
        if (surname) {
            ll_username.background = getDrawable(R.drawable.zz_edittext_wrong)
        }  else {
            ll_username.background = getDrawable(R.drawable.zz_edittext_background)
        }
        if (email) {
            ll_mail.background = getDrawable(R.drawable.zz_edittext_wrong)
        } else {
            ll_mail.background = getDrawable(R.drawable.zz_edittext_background)
        }
        if (emailRepeat) {
            ll_mail_repeat.background = getDrawable(R.drawable.zz_edittext_wrong)
        }  else {
            ll_mail_repeat.background = getDrawable(R.drawable.zz_edittext_background)
        }
        if (password) {
            ll_password.background = getDrawable(R.drawable.zz_edittext_wrong)
        } else {
            ll_password.background = getDrawable(R.drawable.zz_edittext_background)
        }
        if (age) {
            ll_age.background = getDrawable(R.drawable.zz_edittext_wrong)
        }  else {
            ll_age.background = getDrawable(R.drawable.zz_edittext_background)
        }

    }

    override fun onBackPressed() {
    }

    override fun registerSuccess(user: User) {
        Navigator.openHomePage(NavParams(this, true))
    }

}