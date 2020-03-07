package com.jrubiralta.portalbdn.ui.fragment.poll


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.domain.model.GetPollsResponseModel
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.poll.PollPresenter
import com.jrubiralta.portalbdn.presenter.poll.PollPresenterImpl
import com.jrubiralta.portalbdn.ui.adapter.PollAdapter
import com.jrubiralta.portalbdn.ui.fragment.BaseFragment
import com.jrubiralta.portalbdn.ui.view.poll.PollView
import kotlinx.android.synthetic.main.fragment_poll.*


class PollFragment :
        BaseFragment<PollPresenter, PollView>(),
        PollView, PollAdapter.onPollAdapterListener {

    companion object {
        fun newInstance(): PollFragment {
            val fragment = PollFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override val presenter: PollPresenter by instance()

    override val layoutResourceId = R.layout.fragment_poll

    override val fragmentModule: Kodein.Module = Kodein.Module {
        bind<PollPresenter>() with provider {
            PollPresenterImpl(
                    view = this@PollFragment,
                    persistence = instance(),
                    answerPollUseCase = instance(),
                    getPollsUseCase = instance()
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

    override fun showPolls(pollList: List<GetPollsResponseModel>) {
        val pollAdapter = PollAdapter(getCtx(), this)
        rv_poll.adapter = pollAdapter
        rv_poll.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        pollAdapter.replace(pollList.toMutableList())
    }

    override fun updateYes(pollId: String?) {
        presenter.updateAnswer(true, pollId)
    }

    override fun updateNo(pollId: String?) {
        presenter.updateAnswer(false, pollId)
    }
}
