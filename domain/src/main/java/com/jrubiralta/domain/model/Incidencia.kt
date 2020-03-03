package com.jrubiralta.domain.model


data class Incidencia(
        var id: String? = null,
        var userId: String? = null,
        var titol: String? = null,
        var descripcio: String? = null,
        var data: String? = null,
        var hora: String? = null,
        var ubicacio: String? = null,
        var resolt: Boolean? = null)