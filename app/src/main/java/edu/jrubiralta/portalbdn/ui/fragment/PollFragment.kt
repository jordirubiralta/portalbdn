package edu.jrubiralta.portalbdn.ui.fragment

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.presenter.poll.PollPresenter
import edu.jrubiralta.portalbdn.presenter.poll.PollPresenterImpl
import edu.jrubiralta.portalbdn.ui.view.poll.PollView

class PollFragment
    : BaseFragment<PollPresenter, PollView>(),
    PollView {

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
}