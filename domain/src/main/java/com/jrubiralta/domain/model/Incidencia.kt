package com.jrubiralta.domain.model

import java.util.*


data class Incidencia(
        var id: String? = null,
        var userId: String? = null,
        var titol: String? = null,
        var descripcio: String? = null,
        var data: Date? = null,
        var hora: String? = null,
        var ubicacio: String? = null,
        var resolt: Boolean? = null)