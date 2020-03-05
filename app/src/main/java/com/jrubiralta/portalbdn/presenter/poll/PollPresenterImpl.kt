package com.jrubiralta.portalbdn.presenter.poll

import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenter
import com.jrubiralta.portalbdn.ui.view.poll.PollView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView

class PollPresenterImpl(
        view: PollView,
        persistence: Persistence)
    : BasePresenterImpl<PollView>(view, persistence),
        PollPresenter
