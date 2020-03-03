package com.jrubiralta.data.model

import com.google.gson.annotations.SerializedName

data class UserDto(
        @SerializedName("id") val id: String? = null,
        @SerializedName("token") val token: String? = null,
        @SerializedName("email") val email: String? = null,
        @SerializedName("age") var age: Int? = null,
        @SerializedName("name") var name: String? = null,
        @SerializedName("surname") var surname: String? = null)