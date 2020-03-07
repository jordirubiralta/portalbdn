package com.jrubiralta.domain.model

data class GetPollsResponseModel(
        var pollId: String? = null,
        var question: String? = null,
        var answer: Boolean? = null)