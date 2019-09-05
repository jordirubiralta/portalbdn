package edu.jrubiralta.portalbdn.presenter.drawer

import edu.jrubiralta.portalbdn.model.MenuItemView
import edu.jrubiralta.portalbdn.presenter.BasePresenterImpl
import edu.jrubiralta.portalbdn.ui.view.menu.DrawerView

class DrawerPresenterImpl(
    view: DrawerView)
    : BasePresenterImpl<DrawerView>(view),
    DrawerPresenter {

    override fun onViewStart() {
        view.onViewStart()
    }

    override fun serviceSelected(menuItemView: MenuItemView) {
        view.onServiceSelection(menuItemView)
    }

}