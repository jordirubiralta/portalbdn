package com.jrubiralta.portalbdn.ui.fragment.news


import android.os.Bundle
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.news.NewsPresenter
import com.jrubiralta.portalbdn.presenter.news.NewsPresenterImpl
import com.jrubiralta.portalbdn.ui.fragment.BaseFragment
import com.jrubiralta.portalbdn.ui.view.news.NewsView


class NewsFragment :
        BaseFragment<NewsPresenter, NewsView>(),
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
                    view = this@NewsFragment,
                    persistence = instance()
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initViews()
        initListeners()
        initData()
    }

    private fun initViews() {

    }

    private fun initListeners() {

    }

    private fun initData() {

    }

}
