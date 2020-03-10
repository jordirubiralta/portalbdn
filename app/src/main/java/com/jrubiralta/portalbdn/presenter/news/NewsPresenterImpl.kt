package com.jrubiralta.portalbdn.presenter.news

import com.jrubiralta.portalbdn.domain.constants.Constants
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.ui.view.news.NewsView

class NewsPresenterImpl(
        view: NewsView,
        persistence: Persistence)
    : BasePresenterImpl<NewsView>(view, persistence),
        NewsPresenter {

    override fun getNewspaper(): String = persistence.getNewspaper()
}
