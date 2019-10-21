package edu.jrubiralta.portalbdn.ui.activity.login

import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Gravity
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.navigator.Navigator
import edu.jrubiralta.portalbdn.navigator.android.NavParams
import edu.jrubiralta.portalbdn.presenter.login.LoginPresenter
import edu.jrubiralta.portalbdn.presenter.login.LoginPresenterImpl
import edu.jrubiralta.portalbdn.ui.activity.BaseActivity
import edu.jrubiralta.portalbdn.ui.view.login.LoginView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity
    : BaseActivity<LoginPresenter, LoginView>(),
        LoginView,
        LoginListener {

    override val presenter: LoginPresenter by instance()

    override val layoutResourceId = R.layout.activity_login

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<LoginPresenter>() with provider {
            LoginPresenterImpl(
                    view = this@LoginActivity
            )
        }
    }

    private lateinit var toggle: ActionBarDrawerToggle

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
        bt_login.setOnClickListener {
            goToHomeActivity()
        }

        tv_register.setOnClickListener {
            goToRegisterActivity()
        }
    }

    private fun initData() {
    }

    override fun onBackPressed() {
        finish()
    }

    override fun goToHomeActivity() {
        Navigator.openHomePage(NavParams(this@LoginActivity, true))
    }

    override fun goToRegisterActivity() {
        Navigator.openRegisterPage(NavParams(this@LoginActivity, true))
    }
}

interface LoginListener {

}