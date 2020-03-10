package com.jrubiralta.portalbdn.ui.fragment.news


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.domain.constants.Constants
import com.jrubiralta.portalbdn.presenter.news.NewsPresenter
import com.jrubiralta.portalbdn.presenter.news.NewsPresenterImpl
import com.jrubiralta.portalbdn.presenter.news.SettingsPresenter
import com.jrubiralta.portalbdn.presenter.news.SettingsPresenterImpl
import com.jrubiralta.portalbdn.ui.fragment.BaseFragment
import com.jrubiralta.portalbdn.ui.view.news.NewsView
import com.jrubiralta.portalbdn.utils.gone
import com.jrubiralta.portalbdn.utils.visible
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter
import com.twitter.sdk.android.tweetui.UserTimeline
import kotlinx.android.synthetic.main.fragment_news.*


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
        loader.visible()
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

        tweets.layoutManager = LinearLayoutManager(requireContext())

        var config: TwitterConfig = TwitterConfig.Builder(requireContext())
                .twitterAuthConfig(TwitterAuthConfig (Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET))
                .build()
        Twitter.initialize(config)
        val userTimeline = UserTimeline.Builder()
                .maxItemsPerRequest(5)
                .screenName(presenter.getNewspaper())
                .includeRetweets(false)
                .includeReplies(false)
                .build()
        var adapter =  TweetTimelineRecyclerViewAdapter.Builder(requireContext())
                .setTimeline(userTimeline)
                .setViewStyle(R.style.tw__TweetLightStyle)
                .build()
        tweets.adapter = adapter
        loader.gone()
    }

}
