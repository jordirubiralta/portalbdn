package com.jrubiralta.data.model

import com.google.gson.annotations.SerializedName

class IncidenciesDto(
        @SerializedName("_id") val id: String? = null,
        @SerializedName("user_id") val userId: String? = null,
        @SerializedName("title") val titol: String? = null,
        @SerializedName("description") val descripcio: String? = null,
        @SerializedName("date") val data: String? = null,
        @SerializedName("location") val ubicacio: String? = null,
        @SerializedName("resolved") val resolt: Boolean? = null) {

}