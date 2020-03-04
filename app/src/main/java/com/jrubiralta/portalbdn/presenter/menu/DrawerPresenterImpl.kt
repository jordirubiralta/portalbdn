package com.jrubiralta.portalbdn.presenter.menu

import com.jrubiralta.portalbdn.model.MenuItem
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.ui.view.menu.DrawerView

class DrawerPresenterImpl(
        view: DrawerView,
        persistence: Persistence)
    : BasePresenterImpl<DrawerView>(view, persistence),
        DrawerPresenter {

    override fun onViewStart() {
        view.onViewStart()
    }

    override fun serviceSelected(menuItem: MenuItem) {
        view.onServiceSelection(menuItem)
    }

    override fun doLogout() {
        logout()
        view.navigateToLogin()
    }

}