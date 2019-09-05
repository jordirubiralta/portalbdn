package edu.jrubiralta.portalbdn.ui.fragment

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.presenter.news.NewsPresenter
import edu.jrubiralta.portalbdn.presenter.news.NewsPresenterImpl
import edu.jrubiralta.portalbdn.ui.view.news.NewsView

class NewsFragment
    : BaseFragment<NewsPresenter, NewsView>(),
    NewsView {

    companion object {

        fun newInstance(): NewsFragment {
            val fragment = NewsFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override val presenter: NewsPresenter by instance()

    override val layoutResourceId = R.layout.fragment_news

    override val fragmentModule: Kodein.Module = Kodein.Module {
        bind<NewsPresenter>() with provider {
            NewsPresenterImpl(
                view = this@NewsFragment
            )
        }
    }
}