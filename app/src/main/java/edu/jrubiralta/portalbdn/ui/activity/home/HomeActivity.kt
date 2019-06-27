package edu.jrubiralta.portalbdn.ui.activity.home

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.presenter.home.HomePresenter
import edu.jrubiralta.portalbdn.presenter.home.HomePresenterImpl
import edu.jrubiralta.portalbdn.ui.activity.BaseActivity
import edu.jrubiralta.portalbdn.ui.view.home.HomeView

class HomeActivity
    : BaseActivity<HomePresenter, HomeView>(),
        HomeView {

    override val presenter: HomePresenter by instance()

    override val layoutResourceId = R.layout.activity_splash

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<HomePresenter>() with provider {
            HomePresenterImpl(
                view = this@HomeActivity
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
    }

    private fun initData() {
    }

    override fun onBackPressed() {
    }

}