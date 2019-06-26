package edu.jrubiralta.portalbdn.domain.interactor

import edu.jrubiralta.portalbdn.domain.executor.Executor
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.DisposableSubscriber

abstract class FlowableInteractor<T : Any>(
        private val executor: Executor,
        private val compositeDisposable: CompositeDisposable = CompositeDisposable()) {

    fun execute(onNext: (T) -> Unit,
                onComplete: () -> Unit,
                onError: (Throwable) -> Unit): Flowable<T> {
        val flowable = buildFlowable()
                .subscribeOn(executor.new())
                .observeOn(executor.main())

        compositeDisposable.add(flowable
                .subscribeWith(object : DisposableSubscriber<T>() {
                    override fun onComplete() {
                        onComplete()
                    }

                    override fun onNext(t: T) {
                        onNext(t)
                    }

                    override fun onError(e: Throwable) {
                        onError(e)
                    }

                }))

        return flowable
    }

    fun clear() {
        compositeDisposable.clear()
    }

    abstract fun buildFlowable(): Flowable<T>
}
