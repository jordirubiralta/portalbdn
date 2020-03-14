package com.jrubiralta.portalbdn.ui.activity.newIncident

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.incident.NewIncidentPresenter
import com.jrubiralta.portalbdn.presenter.incident.NewIncidentPresenterImpl
import com.jrubiralta.portalbdn.ui.activity.BaseActivity
import com.jrubiralta.portalbdn.ui.view.incident.NewIncidentView
import com.jrubiralta.portalbdn.utils.gone
import com.jrubiralta.portalbdn.utils.visible
import kotlinx.android.synthetic.main.activity_new_incident.*
import kotlinx.android.synthetic.main.view_toolbar.*

class NewIncidentActivity
    : BaseActivity<NewIncidentPresenter, NewIncidentView>(),
        NewIncidentView {

    override val presenter: NewIncidentPresenter by instance()

    override val layoutResourceId = R.layout.activity_new_incident

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<NewIncidentPresenter>() with provider {
            NewIncidentPresenterImpl(
                    view = this@NewIncidentActivity,
                    persistence = instance(),
                    addIncidenciaUseCase = instance()
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
        bt_back.visible()
        bt_menu.gone()
    }

    private fun initListeners() {
        bt_back.setOnClickListener { onBackPressed() }
        btn_ok.setOnClickListener {
            var title = et_title.text.toString()
            var description = et_description.text.toString()
            var location = et_location.text.toString()
            if (!title.isNullOrEmpty() && !description.isNullOrEmpty() && !location.isNullOrEmpty()) {
                presenter.addIncident(title, description, location)
            } else {
                showError(title.isNullOrEmpty(), description.isNullOrEmpty(), location.isNullOrEmpty())
            }
        }
    }

    private fun initData() {
    }

    private fun showError(title: Boolean, description: Boolean, location: Boolean) {
        tv_error.visible()
        tv_error.text = getString(R.string.error_message)
        if (title) {
            ll_title.background = getDrawable(R.drawable.zz_edittext_wrong)
        } else {
            ll_title.background = getDrawable(R.drawable.zz_edittext_background)
        }
        if (description) {
            ll_description.background = getDrawable(R.drawable.zz_edittext_wrong)
        }  else {
            ll_description.background = getDrawable(R.drawable.zz_edittext_background)
        }
        if (location) {
            ll_location.background = getDrawable(R.drawable.zz_edittext_wrong)
        } else {
            ll_location.background = getDrawable(R.drawable.zz_edittext_background)
        }
    }

    override fun navigateToList() {
        onBackPressed() // arreglar gestió de fragment
    }
}
