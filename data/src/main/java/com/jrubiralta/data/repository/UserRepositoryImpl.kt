package com.jrubiralta.data.repository

import com.jrubiralta.data.mapper.toModel
import com.jrubiralta.data.model.SigninDto
import com.jrubiralta.data.model.SignupDto
import com.jrubiralta.data.network.Network
import com.jrubiralta.domain.model.Incidencia
import com.jrubiralta.domain.model.User
import com.jrubiralta.domain.repository.IncidenciesRepository
import com.jrubiralta.domain.repository.UserRepository
import io.reactivex.Single

class UserRepositoryImpl(
        private val network: Network
)
    : UserRepository {

    override fun signin(email: String, password: String): Single<User> {
        val request = SigninDto(email, password)
        return network.signin(request).map { it.toModel() }
    }

    override fun signup(email: String, password: String, name: String, surname: String, age: Int): Single<User> {
        val request = SignupDto(email = email, password = password, name = name, surname = surname,
                age = age)
        return network.signup(request).map { it.toModel() }
    }
}