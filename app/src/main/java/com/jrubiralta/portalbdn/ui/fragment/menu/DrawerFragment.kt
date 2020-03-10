package com.jrubiralta.portalbdn.ui.fragment.menu

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.Navigator.Navigator
import com.jrubiralta.portalbdn.Navigator.android.NavParams
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.domain.constants.Screen
import com.jrubiralta.portalbdn.model.MenuItem
import com.jrubiralta.portalbdn.model.MenuType
import com.jrubiralta.portalbdn.presenter.menu.DrawerPresenter
import com.jrubiralta.portalbdn.presenter.menu.DrawerPresenterImpl
import com.jrubiralta.portalbdn.ui.activity.home.HomeListener
import com.jrubiralta.portalbdn.ui.adapter.DrawerListAdapter
import com.jrubiralta.portalbdn.ui.dialog.LogOutDialog
import com.jrubiralta.portalbdn.ui.fragment.BaseFragment
import com.jrubiralta.portalbdn.ui.view.menu.DrawerView
import kotlinx.android.synthetic.main.fragment_drawer.*


class DrawerFragment :
        BaseFragment<DrawerPresenter, DrawerView>(),
        DrawerView {

    companion object {
        fun newInstance(): DrawerFragment {
            val fragment = DrawerFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override val presenter: DrawerPresenter by instance()

    override val layoutResourceId = R.layout.fragment_drawer

    override val fragmentModule: Kodein.Module = Kodein.Module {
        bind<DrawerPresenter>() with provider {
            DrawerPresenterImpl(
                    view = this@DrawerFragment,
                    persistence = instance()
            )
        }
    }

    private val drawerListAdapter = DrawerListAdapter {
        presenter.serviceSelected(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initViews()
        initListeners()
        initData()
    }

    private fun initViews() {
        rv_drawer_items.adapter = drawerListAdapter
        rv_drawer_items.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rv_drawer_items.overScrollMode = ScrollView.OVER_SCROLL_NEVER
    }

    private fun initListeners() {

    }

    private fun initData() {
        presenter.onViewStart()
    }

    override fun onServiceSelection(menuItem: MenuItem) {
        when (menuItem.type) {
            MenuType.NEWS -> (activity!! as HomeListener).openNewsFragment()
            MenuType.CALENDAR -> (activity!! as HomeListener).openCalendarFragment()
            MenuType.POLLS -> (activity!! as HomeListener).openPollFragment()
            MenuType.INCIDENTS -> (activity!! as HomeListener).openIncidentsFragment()
        }
    }

    override fun onViewStart() {
        val list = mutableListOf<MenuItem>()
        list.add(MenuItem(screen = Screen.NEWS, iconId = R.drawable.ic_newspaper, name = R.string.noticies, type = MenuType.NEWS))
        list.add(MenuItem(screen = Screen.CALENDAR, iconId = R.drawable.ic_calendar_month, name = R.string.calendari, type = MenuType.CALENDAR))
        list.add(MenuItem(screen = Screen.POLLS, iconId = R.drawable.ic_polls, name = R.string.enquestes, type = MenuType.POLLS))
        list.add(MenuItem(screen = Screen.INCIDENTS, iconId = R.drawable.ic_warning, name = R.string.incidencies, type = MenuType.INCIDENTS))
        drawerListAdapter.replace(list)
    }

    override fun navigateToLogin() {
        Navigator.openLoginPage(NavParams(requireActivity(), true))
    }
}
