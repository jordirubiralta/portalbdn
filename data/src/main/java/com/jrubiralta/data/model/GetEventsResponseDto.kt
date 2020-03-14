package com.jrubiralta.data.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class GetEventsResponseDto(
        @SerializedName("title") val title: String? = null,
        @SerializedName("description") val description: String? = null,
        @SerializedName("date") val date: Date? = null,
        @SerializedName("img") val img: String? = null,
        @SerializedName("location") val location: String? = null,
        @SerializedName("organizator") val organizator: String? = null)