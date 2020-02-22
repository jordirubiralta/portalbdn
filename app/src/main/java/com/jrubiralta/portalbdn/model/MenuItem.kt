package com.jrubiralta.portalbdn.model

import com.jrubiralta.portalbdn.domain.constants.Screen

data class MenuItem(
        val screen: Screen,
        val iconId: Int,
        val name: Int,
        val type: MenuType)
