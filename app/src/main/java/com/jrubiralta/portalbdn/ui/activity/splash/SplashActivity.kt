package com.jrubiralta.portalbdn.ui.activity.splash

import android.os.Bundle
import com.enel.edist.presenter.splash.SplashPresenterImpl
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.Navigator.Navigator
import com.jrubiralta.portalbdn.Navigator.android.NavParams
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.splash.SplashPresenter
import com.jrubiralta.portalbdn.ui.activity.BaseActivity
import com.jrubiralta.portalbdn.ui.view.splash.SplashView
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity
    : BaseActivity<SplashPresenter, SplashView>(),
        SplashView {

    override val presenter: SplashPresenter by instance()

    override val layoutResourceId = R.layout.activity_splash

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<SplashPresenter>() with provider {
            SplashPresenterImpl(
                    view = this@SplashActivity,
                    getIncidenciesUseCase = instance()
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
//        setContentView(layoutResourceId)
    }

    private fun initListeners() {
        iv_splash.setOnClickListener {
            Navigator.openLoginPage(NavParams(this, true))
            presenter.getIncidencies()
        }
    }

    private fun initData() {
    }

    override fun onBackPressed() {
    }
}
