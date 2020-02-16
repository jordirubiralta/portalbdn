package edu.jrubiralta.portalbdn.ui.activity.home

import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Gravity
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.navigator.Navigator
import edu.jrubiralta.portalbdn.navigator.android.NavParams
import edu.jrubiralta.portalbdn.presenter.home.HomePresenter
import edu.jrubiralta.portalbdn.presenter.home.HomePresenterImpl
import edu.jrubiralta.portalbdn.ui.activity.BaseActivity
import edu.jrubiralta.portalbdn.ui.fragment.*
import edu.jrubiralta.portalbdn.ui.view.home.HomeView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.view_toolbar.*

class HomeActivity
    : BaseActivity<HomePresenter, HomeView>(),
        HomeView,
        HomeListener {

    override val presenter: HomePresenter by instance()

    override val layoutResourceId = R.layout.activity_home

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<HomePresenter>() with provider {
            HomePresenterImpl(
                view = this@HomeActivity
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
        replaceFragment(R.id.navigation_view_main, DrawerFragment.newInstance())
    }

    private fun initListeners() {
        bt_menu.setOnClickListener { presenter.moveDrawer() }
        bt_add.setOnClickListener { Navigator.openNewIncident(NavParams(this@HomeActivity, false)) }
    }

    private fun initData() {
        replaceFragment(R.id.fragment_container, NewsFragment.newInstance())
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.LEFT)) {
            drawer.closeDrawer(Gravity.LEFT)
        } else {
            finish()
        }
    }

    override fun openHomeFragment() {
        val fragment = NewsFragment.newInstance()
        replaceFragment(R.id.fragment_container, fragment)
        toolbar_title.setText(R.string.inici)
        presenter.moveDrawer()
        bt_add.visibility = View.GONE
    }

    override fun openNewsFragment() {
        val fragment = NewsFragment.newInstance()
        replaceFragment(R.id.fragment_container, fragment)
        toolbar_title.setText(R.string.noticies)
        presenter.moveDrawer()
        bt_add.visibility = View.GONE
    }

    override fun openCalendarFragment() {
        val fragment = CalendarFragment.newInstance()
        replaceFragment(R.id.fragment_container, fragment)
        toolbar_title.setText(R.string.calendari)
        presenter.moveDrawer()
        bt_add.visibility = View.GONE

    }

    override fun openPollFragment() {
        val fragment = PollFragment.newInstance()
        replaceFragment(R.id.fragment_container, fragment)
        toolbar_title.setText(R.string.enquestes)
        presenter.moveDrawer()
        bt_add.visibility = View.GONE
    }

    override fun openIncidentsFragment() {
        val fragment = IncidentsFragment.newInstance()
        replaceFragment(R.id.fragment_container, fragment)
        toolbar_title.setText(R.string.incidencies)
        presenter.moveDrawer()
        bt_add.visibility = View.VISIBLE
    }

    override fun moveDrawer() {
        if (drawer.isDrawerOpen(Gravity.LEFT)) {
            drawer.closeDrawer(Gravity.LEFT)
        } else
            drawer.openDrawer(Gravity.LEFT)
    }


}

interface HomeListener {
    fun openHomeFragment()
    fun openNewsFragment()
    fun openCalendarFragment()
    fun openPollFragment()
    fun openIncidentsFragment()

}