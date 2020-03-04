package com.jrubiralta.portalbdn.persistence

import com.jrubiralta.domain.model.User

interface Persistence {

    fun getAccessToken(): String
    fun setAccessToken(token: String)
    fun hasAccessToken(): Boolean
    fun removeAccessToken()

    fun getUser(): User
    fun setUser(user: User)
    fun hasUser(): Boolean
    fun removeUser()
}