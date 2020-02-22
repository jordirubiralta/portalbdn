package com.jrubiralta.portalbdn

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.jrubiralta.portalbdn.di.appModule
import com.jrubiralta.portalbdn.di.dataModule
import com.jrubiralta.portalbdn.di.domainModule

class App
    : Application() {

    var kodein = Kodein { importDependencies(this) }

    fun importDependencies(kodeinBuilder: Kodein.Builder) {
        kodeinBuilder.import(appModule(this))
        kodeinBuilder.import(domainModule)
        kodeinBuilder.import(dataModule)
    }

}
