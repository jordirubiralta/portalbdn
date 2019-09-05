package edu.jrubiralta.portalbdn.ui.fragment

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import edu.jrubiralta.portalbdn.R
import edu.jrubiralta.portalbdn.presenter.calendar.CalendarPresenter
import edu.jrubiralta.portalbdn.presenter.calendar.CalendarPresenterImpl
import edu.jrubiralta.portalbdn.ui.view.calendar.CalendarView

class CalendarFragment
    : BaseFragment<CalendarPresenter, CalendarView>(),
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
}