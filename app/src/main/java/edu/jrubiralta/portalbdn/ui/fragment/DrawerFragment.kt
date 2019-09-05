package edu.jrubiralta.portalbdn.ui.fragment

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.view.menu.MenuAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.domain.constants.Screen
import edu.jrubiralta.portalbdn.model.MenuItemView
import edu.jrubiralta.portalbdn.navigator.Navigator
import edu.jrubiralta.portalbdn.presenter.drawer.DrawerPresenter
import edu.jrubiralta.portalbdn.presenter.drawer.DrawerPresenterImpl
import edu.jrubiralta.portalbdn.ui.adapter.DrawerListAdapter
import edu.jrubiralta.portalbdn.ui.view.fragments.DrawerView
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
                view = this@DrawerFragment
            )
        }
    }

    private val drawerListAdapter = DrawerListAdapter()

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
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
        rv_drawer_items.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        rv_drawer_items.overScrollMode = ScrollView.OVER_SCROLL_NEVER
    }

    private fun initListeners() {

    }

    private fun initData() {
        presenter.onViewStart()
    }


    override fun onViewStart() {
        val list = mutableListOf<MenuItemView>()
        list.add(MenuItemView(screen = Screen.HOME, iconId = R.drawable.ic_home, nameId = R.string.inici))
        list.add(MenuItemView(screen = Screen.HOME, iconId = R.drawable.ic_news, nameId = R.string.noticies))
        list.add(MenuItemView(screen = Screen.HOME, iconId = R.drawable.ic_calendar, nameId = R.string.calendari))
        list.add(MenuItemView(screen = Screen.HOME, iconId = R.drawable.ic_poll, nameId = R.string.enquestes))
        list.add(MenuItemView(screen = Screen.HOME, iconId = R.drawable.ic_problems, nameId = R.string.incidencies))
        drawerListAdapter.replace(list)
    }
}
