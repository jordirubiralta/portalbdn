package com.jrubiralta.portalbdn.ui.fragment.incident


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.incident.IncidentListPresenter
import com.jrubiralta.portalbdn.presenter.incident.IncidentListPresenterImpl
import com.jrubiralta.portalbdn.ui.adapter.IncidentAdapter
import com.jrubiralta.portalbdn.ui.fragment.BaseFragment
import com.jrubiralta.portalbdn.ui.view.incident.IncidentListView
import kotlinx.android.synthetic.main.fragment_incidents.*


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
                    view = this@IncidentListFragment,
                    persistence = instance(),
                    getIncidenciesUseCase = instance()
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

    override fun showIncidents(incidentsList: List<Incidencia>) {
        val incidentAdapter = IncidentAdapter(getCtx())
        rv_incidents.adapter = incidentAdapter
        rv_incidents.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        incidentAdapter.replace(incidentsList.toMutableList())
    }

}
