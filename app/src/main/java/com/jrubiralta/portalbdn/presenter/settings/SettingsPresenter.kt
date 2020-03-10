package com.jrubiralta.portalbdn.presenter.news

import com.jrubiralta.portalbdn.presenter.BasePresenter
import com.jrubiralta.portalbdn.ui.view.news.NewsView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView
import com.jrubiralta.portalbdn.ui.view.settings.SettingsView

interface SettingsPresenter
    : BasePresenter<SettingsView> {

    fun saveDefaultNewspaper(newspaper: String)
    fun getDefaultNewspaper(): String
}
