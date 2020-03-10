package com.jrubiralta.portalbdn.ui.activity.home

import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.Navigator.Navigator
import com.jrubiralta.portalbdn.Navigator.android.NavParams
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.home.HomePresenter
import com.jrubiralta.portalbdn.presenter.home.HomePresenterImpl
import com.jrubiralta.portalbdn.ui.activity.BaseActivity
import com.jrubiralta.portalbdn.ui.dialog.NewsInfoDialog
import com.jrubiralta.portalbdn.ui.fragment.calendar.CalendarFragment
import com.jrubiralta.portalbdn.ui.fragment.incident.IncidentListFragment
import com.jrubiralta.portalbdn.ui.fragment.menu.DrawerFragment
import com.jrubiralta.portalbdn.ui.fragment.news.NewsFragment
import com.jrubiralta.portalbdn.ui.fragment.poll.PollFragment
import com.jrubiralta.portalbdn.ui.view.home.HomeView
import com.jrubiralta.portalbdn.utils.gone
import com.jrubiralta.portalbdn.utils.visible
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
                    view = this@HomeActivity,
                    persistence = instance()
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
        replaceFragment(R.id.navigation_view_main, DrawerFragment.newInstance())
        openNewsFragment()
    }

    private fun initListeners() {
        bt_menu.setOnClickListener { presenter.moveDrawer() }
        bt_add.setOnClickListener { Navigator.openNewIncidentPage(NavParams(this, false)) }
        bt_info.setOnClickListener { NewsInfoDialog.newInstance().show(supportFragmentManager, "alert") }
    }

    private fun initData() {
        presenter.getData()
    }

    override fun onBackPressed() {
    }

    override fun moveDrawer() {
        if (drawer.isDrawerOpen(Gravity.LEFT)) {
            drawer.closeDrawer(Gravity.LEFT)
        } else
            drawer.openDrawer(Gravity.LEFT)
    }

    override fun openNewsFragment() {
        val fragment = NewsFragment.newInstance()
        replaceFragment(R.id.fragment_container, fragment)
        toolbar_title.setText(R.string.noticies)
        presenter.moveDrawer()
        bt_add.gone()
        bt_info.visible()
    }

    override fun openCalendarFragment() {
        val fragment = CalendarFragment.newInstance()
        replaceFragment(R.id.fragment_container, fragment)
        toolbar_title.setText(R.string.calendari)
        presenter.moveDrawer()
        bt_add.gone()
        bt_info.gone()
    }

    override fun openPollFragment() {
        val fragment = PollFragment.newInstance()
        replaceFragment(R.id.fragment_container, fragment)
        toolbar_title.setText(R.string.enquestes)
        presenter.moveDrawer()
        bt_add.gone()
        bt_info.gone()
    }

    override fun openIncidentsFragment() {
        val fragment = IncidentListFragment.newInstance()
        replaceFragment(R.id.fragment_container, fragment)
        toolbar_title.setText(R.string.incidencies)
        presenter.moveDrawer()
        bt_add.gone()
        bt_info.gone()
    }

    override fun openSettingsActivity() {
        Navigator.openSettingsPage(NavParams(this, false))
    }
}

interface HomeListener {
    fun openNewsFragment()
    fun openCalendarFragment()
    fun openPollFragment()
    fun openIncidentsFragment()
    fun openSettingsActivity()
}