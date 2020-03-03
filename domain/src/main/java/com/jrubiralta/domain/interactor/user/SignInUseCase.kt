package com.jrubiralta.domain.interactor.user

import com.jrubiralta.domain.model.User
import com.jrubiralta.domain.repository.UserRepository
import com.jrubiralta.portalbdn.domain.executor.Executor
import com.jrubiralta.portalbdn.domain.interactor.SingleInteractor

class SignInUseCase(
        private val repository: UserRepository,
        executor: Executor)
    : SingleInteractor<User>(executor = executor) {

    lateinit var email: String
    lateinit var password: String

    fun execute(email: String, password: String, onSuccess: (User) -> Unit, onError: (Throwable) -> Unit) {
        this.email = email
        this.password = password

        super.execute(onSuccess = onSuccess, onError = onError, single = repository.signin(email, password))
    }
}