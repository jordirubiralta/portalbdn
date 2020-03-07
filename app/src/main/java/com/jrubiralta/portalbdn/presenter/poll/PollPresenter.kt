package com.jrubiralta.portalbdn.presenter.poll

import com.jrubiralta.portalbdn.presenter.BasePresenter
import com.jrubiralta.portalbdn.ui.view.poll.PollView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView

interface PollPresenter
    : BasePresenter<PollView> {

    fun updateAnswer(answer: Boolean, pollId: String?)

}
