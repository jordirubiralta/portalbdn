package com.jrubiralta.domain.model

data class User(
        var id: String? = null,
        var token: String? = null,
        var email: String? = null,
        var age: Int? = null,
        var name: String? = null,
        var surname: String? = null)