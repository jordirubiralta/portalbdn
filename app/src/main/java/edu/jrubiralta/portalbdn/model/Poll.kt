package edu.jrubiralta.portalbdn.model

data class PollItemView(
        val title: String,
        val correctAnswers: Int,
        val negativeAnswers: Int)