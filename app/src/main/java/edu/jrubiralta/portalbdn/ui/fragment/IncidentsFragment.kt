package edu.jrubiralta.portalbdn.ui.fragment

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.presenter.incident.IncidentsPresenter
import edu.jrubiralta.portalbdn.presenter.incident.IncidentsPresenterImpl
import edu.jrubiralta.portalbdn.ui.view.indicents.IncidentsView


class IncidentsFragment
    : BaseFragment<IncidentsPresenter, IncidentsView>(),
    IncidentsView {

    companion object {

        fun newInstance(): IncidentsFragment {
            val fragment = IncidentsFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override val presenter: IncidentsPresenter by instance()

    override val layoutResourceId = R.layout.fragment_incidents

    override val fragmentModule: Kodein.Module = Kodein.Module {
        bind<IncidentsPresenter>() with provider {
            IncidentsPresenterImpl(
                view = this@IncidentsFragment
            )
        }
    }
}