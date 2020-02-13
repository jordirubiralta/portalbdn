package edu.jrubiralta.portalbdn.ui.activity.register

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.presenter.register.RegisterPresenter
import edu.jrubiralta.portalbdn.presenter.register.RegisterPresenterImpl
import edu.jrubiralta.portalbdn.ui.activity.BaseActivity
import edu.jrubiralta.portalbdn.ui.view.register.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity
    : BaseActivity<RegisterPresenter, RegisterView>(),
        RegisterView,
        RegisterListener {

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
        tv_do_login.setOnClickListener { onBackPressed() }
    }

    private fun initData() {
    }

}

interface RegisterListener {

}