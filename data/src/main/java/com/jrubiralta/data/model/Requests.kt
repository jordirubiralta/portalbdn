package com.jrubiralta.data.model

import com.google.gson.annotations.SerializedName

data class SigninDto(
        @SerializedName("email") val email: String,
        @SerializedName("password") val password: String
)

data class IncidenciaRequestDto(
        @SerializedName("user_id") val userId: String
)
