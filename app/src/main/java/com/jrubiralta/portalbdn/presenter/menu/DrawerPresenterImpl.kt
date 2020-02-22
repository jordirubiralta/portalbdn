package com.jrubiralta.portalbdn.presenter.menu

import com.jrubiralta.portalbdn.model.MenuItem
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.ui.view.menu.DrawerView

class DrawerPresenterImpl(
        view: DrawerView)
    : BasePresenterImpl<DrawerView>(view),
        DrawerPresenter {

    override fun onViewStart() {
        view.onViewStart()
    }

    override fun serviceSelected(menuItem: MenuItem) {
        view.onServiceSelection(menuItem)
    }

}