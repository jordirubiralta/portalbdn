package com.jrubiralta.data.model

import com.google.gson.annotations.SerializedName

class IncidenciesDto(
    @SerializedName("titol") val titol: String? = null,
    @SerializedName("descripcio") val descripcio: String? = null,
    @SerializedName("data") val data: String? = null,
    @SerializedName("hora") val hora: String? = null,
    @SerializedName("ubicacio") val ubicacio: String? = null,
    @SerializedName("resolt") val resolt: Boolean? = null) {

}