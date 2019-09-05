package edu.jrubiralta.portalbdn.model

import edu.jrubiralta.portalbdn.domain.constants.Screen

data class MenuItemView(
    val screen: Screen,
    val iconId: Int,
    val name: Int,
    val type: MenuType)
