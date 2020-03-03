package com.jrubiralta.domain.repository

import com.jrubiralta.domain.model.User
import io.reactivex.Single

interface UserRepository {
    fun signin(email: String, password: String): Single<User>
}

