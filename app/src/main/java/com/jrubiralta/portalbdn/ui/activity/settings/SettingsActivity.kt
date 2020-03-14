package com.jrubiralta.portalbdn.ui.activity.settings

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.Navigator.Navigator
import com.jrubiralta.portalbdn.Navigator.android.NavParams
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.domain.constants.Constants
import com.jrubiralta.portalbdn.presenter.news.SettingsPresenter
import com.jrubiralta.portalbdn.presenter.news.SettingsPresenterImpl
import com.jrubiralta.portalbdn.ui.activity.BaseActivity
import com.jrubiralta.portalbdn.ui.dialog.LogOutDialog
import com.jrubiralta.portalbdn.ui.view.settings.SettingsView
import com.jrubiralta.portalbdn.utils.gone
import com.jrubiralta.portalbdn.utils.visible
import kotlinx.android.synthetic.main.activity_register.rb_diaribadalona
import kotlinx.android.synthetic.main.activity_register.rb_independent
import kotlinx.android.synthetic.main.activity_register.rb_totbadalona
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.view_toolbar.*

class SettingsActivity
    : BaseActivity<SettingsPresenter, SettingsView>(),
        SettingsView {


    override val presenter: SettingsPresenter by instance()

    override val layoutResourceId = R.layout.activity_settings

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<SettingsPresenter>() with provider {
            SettingsPresenterImpl(
                    view = this@SettingsActivity,
                    persistence = instance()
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
        toolbar_title.setText(R.string.configuracio)
        bt_back.visible()
        bt_menu.gone()
    }

    private fun initListeners() {
        bt_back.setOnClickListener { onBackPressed() }

        rb_diaribadalona.setOnClickListener {
            rb_independent.isChecked = false
            rb_totbadalona.isChecked = false
            rb_diaribadalona.isChecked = true
        }

        rb_independent.setOnClickListener {
            rb_independent.isChecked = true
            rb_totbadalona.isChecked = false
            rb_diaribadalona.isChecked = false
        }

        rb_totbadalona.setOnClickListener {
            rb_independent.isChecked = false
            rb_totbadalona.isChecked = true
            rb_diaribadalona.isChecked = false
        }

        logout.setOnClickListener {
            LogOutDialog.newInstance(listener = object : LogOutDialog.LogoutDialogListener {
                override fun onOkClicked() {
                    presenter.logout()
                    Navigator.openLoginPage(NavParams(this@SettingsActivity, true))
                }
            }).show(supportFragmentManager, "logout")
        }
    }

    private fun initData() {
        var defaultNewspaper = presenter.getDefaultNewspaper()
        when (defaultNewspaper) {
            Constants.NEWS_DIARI_DE_BADALONA-> rb_diaribadalona.isChecked = true
            Constants.NEWS_TOTBADALONA -> rb_totbadalona.isChecked = true
            else -> rb_independent.isChecked = true
        }
    }

    private fun getSelectedNewspaper(): String =
            when {
                rb_diaribadalona.isChecked -> Constants.NEWS_DIARI_DE_BADALONA
                rb_totbadalona.isChecked -> Constants.NEWS_TOTBADALONA
                else -> Constants.NEWS_INDEPENDENT
            }

    override fun onBackPressed() {
        super.onBackPressed()
        presenter.saveDefaultNewspaper(getSelectedNewspaper())
    }
}