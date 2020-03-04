package com.jrubiralta.portalbdn.ui.view.menu

import com.jrubiralta.portalbdn.model.MenuItem
import com.jrubiralta.portalbdn.ui.view.View

interface DrawerView
    : View {

    fun onViewStart()
    fun onServiceSelection(menuItem: MenuItem)

    fun navigateToLogin()
}
