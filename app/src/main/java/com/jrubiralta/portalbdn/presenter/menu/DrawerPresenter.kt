package com.jrubiralta.portalbdn.presenter.menu

import com.jrubiralta.portalbdn.model.MenuItem
import com.jrubiralta.portalbdn.presenter.BasePresenter
import com.jrubiralta.portalbdn.ui.view.menu.DrawerView

interface DrawerPresenter
    : BasePresenter<DrawerView> {

    fun onViewStart()
    fun serviceSelected(menuItem: MenuItem)
}
