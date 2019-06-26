package edu.jrubiralta.portalbdn.ui.activity.Splash

import android.os.Bundle
import com.enel.edist.presenter.splash.SplashPresenterImpl
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.presenter.splash.SplashPresenter
import edu.jrubiralta.portalbdn.ui.activity.BaseActivity
import edu.jrubiralta.portalbdn.ui.view.Splash.SplashView

class SplashActivity
    : BaseActivity<SplashPresenter, SplashView>(),
    SplashView {

    override val presenter: SplashPresenter by instance()

    override val layoutResourceId = R.layout.activity_splash

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<SplashPresenter>() with provider {
            SplashPresenterImpl(
                view = this@SplashActivity
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
    }

    private fun initListeners() {
    }

    private fun initData() {
    }

    override fun onBackPressed() {
    }

}
