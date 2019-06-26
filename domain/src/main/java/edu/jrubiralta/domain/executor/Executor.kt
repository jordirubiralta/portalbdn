package edu.jrubiralta.portalbdn.domain.executor

import io.reactivex.Scheduler

interface Executor {
    fun new(): Scheduler
    fun main(): Scheduler
}