package edu.jrubiralta.portalbdn.ui.fragment

import android.os.Bundle
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
import edu.jrubiralta.portalbdn.model.MenuType
import edu.jrubiralta.portalbdn.navigator.Navigator
import edu.jrubiralta.portalbdn.navigator.android.NavParams
import edu.jrubiralta.portalbdn.presenter.drawer.DrawerPresenter
import edu.jrubiralta.portalbdn.presenter.drawer.DrawerPresenterImpl
import edu.jrubiralta.portalbdn.ui.activity.home.HomeListener
import edu.jrubiralta.portalbdn.ui.adapter.DrawerListAdapter
import edu.jrubiralta.portalbdn.ui.view.menu.DrawerView
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
        rv_drawer_items.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        rv_drawer_items.overScrollMode = ScrollView.OVER_SCROLL_NEVER
    }

    private fun initListeners() {

    }

    private fun initData() {
        presenter.onViewStart()
    }

    override fun onServiceSelection(menuItemView: MenuItemView) {
        when (menuItemView.type) {
            MenuType.HOME -> (activity!! as HomeListener)?.openHomeFragment()
            MenuType.NEWS -> (activity!! as HomeListener)?.openNewsFragment()
            MenuType.CALENDAR -> (activity!! as HomeListener)?.openCalendarFragment()
            MenuType.POLLS -> (activity!! as HomeListener)?.openPollFragment()
            MenuType.INCIDENTS -> (activity!! as HomeListener)?.openIncidentsFragment()
        }
    }

    override fun onViewStart() {
        val list = mutableListOf<MenuItemView>()
        list.add(MenuItemView(screen = Screen.HOME, iconId = R.drawable.ic_home, name = R.string.inici, type = MenuType.HOME))
        list.add(MenuItemView(screen = Screen.NEWS, iconId = R.drawable.ic_news, name = R.string.noticies, type = MenuType.NEWS))
        list.add(MenuItemView(screen = Screen.CALENDAR, iconId = R.drawable.ic_calendar, name = R.string.calendari, type = MenuType.CALENDAR))
        list.add(MenuItemView(screen = Screen.POLLS, iconId = R.drawable.ic_poll, name = R.string.enquestes, type = MenuType.POLLS))
        list.add(MenuItemView(screen = Screen.INCIDENTS, iconId = R.drawable.ic_problems, name = R.string.incidencies, type = MenuType.INCIDENTS))
        drawerListAdapter.replace(list)
    }


}
