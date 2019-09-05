package edu.jrubiralta.portalbdn.presenter.news

import edu.jrubiralta.portalbdn.presenter.BasePresenterImpl
import edu.jrubiralta.portalbdn.ui.view.news.NewsView

class NewsPresenterImpl(
    view: NewsView)
    : BasePresenterImpl<NewsView>(view),
    NewsPresenter {

}