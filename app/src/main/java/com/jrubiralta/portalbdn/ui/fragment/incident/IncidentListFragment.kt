package com.jrubiralta.portalbdn.ui.fragment.incident


import android.os.Bundle
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.calendar.CalendarPresenter
import com.jrubiralta.portalbdn.presenter.calendar.CalendarPresenterImpl
import com.jrubiralta.portalbdn.presenter.incident.IncidentListPresenter
import com.jrubiralta.portalbdn.presenter.incident.IncidentListPresenterImpl
import com.jrubiralta.portalbdn.ui.fragment.BaseFragment
import com.jrubiralta.portalbdn.ui.view.calendar.CalendarView
import com.jrubiralta.portalbdn.ui.view.incident.IncidentListView


class IncidentListFragment :
        BaseFragment<IncidentListPresenter, IncidentListView>(),
        IncidentListView {

    companion object {
        fun newInstance(): IncidentListFragment {
            val fragment = IncidentListFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override val presenter: IncidentListPresenter by instance()

    override val layoutResourceId = R.layout.fragment_incidents

    override val fragmentModule: Kodein.Module = Kodein.Module {
        bind<IncidentListPresenter>() with provider {
            IncidentListPresenterImpl(
                    view = this@IncidentListFragment
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
