package com.jrubiralta.portalbdn.presenter.poll

import com.jrubiralta.domain.interactor.polls.AnswerPollUseCase
import com.jrubiralta.domain.interactor.polls.GetPollsUseCase
import com.jrubiralta.portalbdn.persistence.Persistence
import com.jrubiralta.portalbdn.presenter.BasePresenterImpl
import com.jrubiralta.portalbdn.presenter.registre.RegisterPresenter
import com.jrubiralta.portalbdn.ui.view.poll.PollView
import com.jrubiralta.portalbdn.ui.view.registre.RegisterView

class PollPresenterImpl(
        view: PollView,
        persistence: Persistence,
        private val answerPollUseCase: AnswerPollUseCase,
        private val getPollsUseCase: GetPollsUseCase)
    : BasePresenterImpl<PollView>(view, persistence),
        PollPresenter {

    override fun init() {
        super.init()
        getPolls()
    }

    private fun getPolls() {
        getPollsUseCase.execute(
                onSuccess = {
                    view.showPolls(it)
                },
                onError = {
                    // TO DO DIALOG FOR ERROR
                }
        )
    }

    override fun updateAnswer(answer: Boolean, pollId: String?) {
        pollId?.let {
            answerPollUseCase.execute(pollId = pollId, answer = answer,
                    onSuccess = {

                    },
                    onError = {

                    })
        }
    }
}
