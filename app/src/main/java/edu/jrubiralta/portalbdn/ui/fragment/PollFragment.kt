package edu.jrubiralta.portalbdn.ui.fragment

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.model.PollItemView
import edu.jrubiralta.portalbdn.presenter.poll.PollPresenter
import edu.jrubiralta.portalbdn.presenter.poll.PollPresenterImpl
import edu.jrubiralta.portalbdn.ui.adapter.PollAdapter
import edu.jrubiralta.portalbdn.ui.view.poll.PollView
import kotlinx.android.synthetic.main.fragment_poll.*

class PollFragment
    : BaseFragment<PollPresenter, PollView>(),
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
                    view = this@PollFragment
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initView()
        initListeners()
        initData()
    }

    private fun initView() {
        initAdapter()
    }

    private fun initListeners() {
    }

    private fun initData() {
    }

    private fun initAdapter() {
        val pollAdapter = PollAdapter(getCtx(), this)
        rv_poll.adapter = pollAdapter
        rv_poll.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        val list = mutableListOf<PollItemView>()
        list.add(PollItemView(title = "Creus que hem de afegir cendrés a les escombraries?", correctAnswers = 10, negativeAnswers = 3))
        list.add(PollItemView(title = "S'hauria de reformar el pont del petroli?", correctAnswers = 100, negativeAnswers = 5))
        pollAdapter.replace(list)
    }

    override fun updateYes() {
    }

    override fun updateNo() {
    }

}