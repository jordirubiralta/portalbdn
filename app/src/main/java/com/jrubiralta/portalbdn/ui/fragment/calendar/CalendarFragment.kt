package com.jrubiralta.portalbdn.ui.fragment.calendar

import android.os.Bundle
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.jrubiralta.portalbdn.R
import com.jrubiralta.portalbdn.presenter.calendar.CalendarPresenter
import com.jrubiralta.portalbdn.presenter.calendar.CalendarPresenterImpl
import com.jrubiralta.portalbdn.ui.fragment.BaseFragment
import com.jrubiralta.portalbdn.ui.view.calendar.CalendarView


class CalendarFragment :
        BaseFragment<CalendarPresenter, CalendarView>(),
        CalendarView {

    companion object {
        fun newInstance(): CalendarFragment {
            val fragment = CalendarFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override val presenter: CalendarPresenter by instance()

    override val layoutResourceId = R.layout.fragment_calendar

    override val fragmentModule: Kodein.Module = Kodein.Module {
        bind<CalendarPresenter>() with provider {
            CalendarPresenterImpl(
                    view = this@CalendarFragment
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
