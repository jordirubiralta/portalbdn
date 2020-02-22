package com.jrubiralta.portalbdn.ui.activity.newIncident

import android.os.Bundle
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.incident.NewIncidentPresenter
import com.jrubiralta.portalbdn.presenter.incident.NewIncidentPresenterImpl
import com.jrubiralta.portalbdn.ui.activity.BaseActivity
import com.jrubiralta.portalbdn.ui.view.incident.NewIncidentView
import kotlinx.android.synthetic.main.view_toolbar.*

class NewIncidentActivity
    : BaseActivity<NewIncidentPresenter, NewIncidentView>(),
        NewIncidentView {

    override val presenter: NewIncidentPresenter by instance()

    override val layoutResourceId = R.layout.activity_new_incident

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<NewIncidentPresenter>() with provider {
            NewIncidentPresenterImpl(
                    view = this@NewIncidentActivity
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initView()
        initListeners()
        initData()
    }

    private fun initView() {
        setContentView(layoutResourceId)
        toolbar_title.setText(R.string.nova_incidencia)
        bt_back.visibility = View.VISIBLE
        bt_menu.visibility = View.GONE
    }

    private fun initListeners() {
        bt_back.setOnClickListener { onBackPressed() }
    }

    private fun initData() {
    }
}
