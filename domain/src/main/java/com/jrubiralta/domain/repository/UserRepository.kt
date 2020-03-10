package com.jrubiralta.domain.repository

import com.jrubiralta.domain.model.User
import io.reactivex.Single

interface UserRepository {
    fun signin(email: String, password: String): Single<User>
    fun signup(email: String, password: String, name: String, surname: String, age: Int, newspaper: String): Single<User>
}

