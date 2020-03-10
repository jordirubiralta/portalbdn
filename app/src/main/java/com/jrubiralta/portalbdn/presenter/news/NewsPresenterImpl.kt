package com.jrubiralta.portalbdn.presenter.news

import com.jrubiralta.portalbdn.domain.constants.Constants
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenter
import com.jrubiralta.portalbdn.ui.view.news.NewsView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView

class NewsPresenterImpl(
        view: NewsView,
        persistence: Persistence)
    : BasePresenterImpl<NewsView>(view, persistence),
        NewsPresenter {

    override fun getNewspaper(): String =
        persistence.getUser().newspaper?.let {
             it
        } ?: run {
             Constants.EMPTY_STRING
        }
}
