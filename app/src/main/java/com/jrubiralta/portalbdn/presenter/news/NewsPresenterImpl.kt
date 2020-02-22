package com.jrubiralta.portalbdn.presenter.news

import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenter
import com.jrubiralta.portalbdn.ui.view.news.NewsView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView

class NewsPresenterImpl(
        view: NewsView)
    : BasePresenterImpl<NewsView>(view),
        NewsPresenter {
}
