package com.jrubiralta.data.model

import com.google.gson.annotations.SerializedName

data class SigninDto(
        @SerializedName("email") val email: String,
        @SerializedName("password") val password: String
)

data class SignupDto(
        @SerializedName("email") val email: String,
        @SerializedName("password") val password: String,
        @SerializedName("name") val name: String,
        @SerializedName("surname") val surname: String,
        @SerializedName("age") val age: Int,
        @SerializedName("newspaper") val newspaper: String
)

data class IncidenciaRequestDto(
        @SerializedName("user_id") val userId: String
)