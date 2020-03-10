package com.jrubiralta.data.persistence

import android.content.Context
import com.google.gson.Gson
import com.jrubiralta.domain.model.User
import com.jrubiralta.portalbdn.domain.constants.Constants
import com.jrubiralta.portalbdn.persistence.Persistence

class PortalPreferences(context: Context, name: String) : Persistence {

    companion object {
        private const val ACCESS_TOKEN_KEY: String = "ACCESS_TOKEN_KEY"
        private const val USER_KEY: String = "USER_KEY"
        private const val NEWSPAPER_KEY: String = "NEWSPAPER_KEY"
    }

    private val gson = Gson()

    private val sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    private fun getString(key: String, defaultValue: String = Constants.EMPTY_STRING): String = sharedPreferences.getString(key, defaultValue)!!

    private fun setString(key: String, value: String) {
        sharedPreferences.edit()
                .putString(key, value)
                .apply()
    }

    private fun removeKey(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    override fun getAccessToken(): String = getString(ACCESS_TOKEN_KEY)
    override fun setAccessToken(token: String) = setString(ACCESS_TOKEN_KEY, token)
    override fun hasAccessToken(): Boolean = sharedPreferences.contains(ACCESS_TOKEN_KEY)
    override fun removeAccessToken() = removeKey(ACCESS_TOKEN_KEY)

    override fun getUser(): User = gson.fromJson(getString(USER_KEY), User::class.java)
    override fun setUser(user: User) = setString(USER_KEY, gson.toJson(user))
    override fun hasUser(): Boolean = sharedPreferences.contains(USER_KEY)
    override fun removeUser() = removeKey(USER_KEY)

    override fun getNewspaper(): String = getString(NEWSPAPER_KEY)
    override fun setNewspaper(newspaper: String) = setString(NEWSPAPER_KEY, newspaper)
    override fun hasNewspaper(): Boolean = sharedPreferences.contains(NEWSPAPER_KEY)
    override fun removeNewspaper() = removeKey(NEWSPAPER_KEY)
}