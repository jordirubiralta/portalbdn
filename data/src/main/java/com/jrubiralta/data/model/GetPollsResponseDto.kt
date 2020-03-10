package com.jrubiralta.data.model

import com.google.gson.annotations.SerializedName

data class GetPollsResponseDto(
        @SerializedName("poll_id") val pollId: String? = null,
        @SerializedName("question") val question: String? = null,
        @SerializedName("answer") val answer: Boolean? = null)