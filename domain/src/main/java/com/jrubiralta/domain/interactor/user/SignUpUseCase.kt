package com.jrubiralta.domain.interactor.user

import com.jrubiralta.domain.model.User
import com.jrubiralta.domain.repository.UserRepository
import com.jrubiralta.portalbdn.domain.executor.Executor
import com.jrubiralta.portalbdn.domain.interactor.SingleInteractor

class SignUpUseCase(
        private val repository: UserRepository,
        executor: Executor)
    : SingleInteractor<User>(executor = executor) {

    lateinit var email: String
    lateinit var password: String
    lateinit var name: String
    lateinit var surname: String
    var age = 18
    lateinit var newspaper: String

    fun execute(email: String, password: String, name: String, surname: String, age: Int, newspaper: String,
                onSuccess: (User) -> Unit, onError: (Throwable) -> Unit) {
        this.email = email
        this.password = password
        this.name = name
        this.surname = surname
        this.age = age
        this.newspaper = newspaper

        super.execute(onSuccess = onSuccess, onError = onError,
                single = repository.signup(email, password, name, surname, age, newspaper))
    }
}