package com.jrubiralta.domain.model

import java.util.*

data class GetEventsResponseModel(
        var title: String? = null,
        var description: String? = null,
        var date: Date? = null,
        var img: String? = null,
        var location: String? = null,
        var organizator: String? = null)