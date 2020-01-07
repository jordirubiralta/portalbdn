package edu.jrubiralta.portalbdn.ui.activity.register

import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.presenter.register.RegisterPresenter
import edu.jrubiralta.portalbdn.presenter.register.RegisterPresenterImpl
import edu.jrubiralta.portalbdn.ui.activity.BaseActivity
import edu.jrubiralta.portalbdn.ui.view.register.RegisterView
import kotlinx.android.synthetic.main.view_toolbar.*

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
        toolbar_title.setText(R.string.register_title)
        bt_back.visibility = View.VISIBLE
        bt_menu.visibility = View.GONE
    }

    private fun initListeners() {
        bt_back.setOnClickListener { onBackPressed() }
    }

    private fun initData() {
    }

}

interface RegisterListener {

}