package com.jrubiralta.portalbdn.presenter.news

import com.jrubiralta.portalbdn.domain.constants.Constants
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.ui.view.news.NewsView
import com.jrubiralta.portalbdn.ui.view.settings.SettingsView

class SettingsPresenterImpl(
        view: SettingsView,
        persistence: Persistence)
    : BasePresenterImpl<SettingsView>(view, persistence),
        SettingsPresenter {


    override fun saveDefaultNewspaper(newspaper: String) {
        persistence.setNewspaper(newspaper)
    }

    override fun getDefaultNewspaper() = persistence.getNewspaper()
}
