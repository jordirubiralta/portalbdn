package com.jrubiralta.portalbdn.ui.view.poll

import com.jrubiralta.domain.model.GetPollsResponseModel
import com.jrubiralta.portalbdn.ui.view.View

interface PollView
    : View {

    fun showPolls(pollList: List<GetPollsResponseModel>)

}
