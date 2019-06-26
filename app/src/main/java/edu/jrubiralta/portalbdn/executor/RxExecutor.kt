package edu.jrubiralta.portalbdn.executor

import edu.jrubiralta.portalbdn.domain.executor.Executor
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxExecutor
    : Executor {
    override fun new(): Scheduler = Schedulers.io()
    override fun main(): Scheduler = AndroidSchedulers.mainThread()
}