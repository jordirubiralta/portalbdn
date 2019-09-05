package edu.jrubiralta.portalbdn.presenter.drawer

import edu.jrubiralta.portalbdn.model.MenuItemView
import edu.jrubiralta.portalbdn.presenter.BasePresenter
import edu.jrubiralta.portalbdn.ui.view.menu.DrawerView

interface DrawerPresenter
    : BasePresenter<DrawerView> {

    fun onViewStart()
    fun serviceSelected(menuItemView: MenuItemView)
}
