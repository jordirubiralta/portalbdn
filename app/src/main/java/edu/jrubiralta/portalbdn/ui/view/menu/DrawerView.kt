package edu.jrubiralta.portalbdn.ui.view.menu

import edu.jrubiralta.portalbdn.model.MenuItemView
import edu.jrubiralta.portalbdn.ui.view.View


interface DrawerView
    : View {

    fun onViewStart()
    fun onServiceSelection(menuItemView: MenuItemView)
}
