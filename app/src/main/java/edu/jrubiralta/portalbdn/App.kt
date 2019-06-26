package edu.jrubiralta.portalbdn

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import edu.jrubiralta.portalbdn.di.appModule
import edu.jrubiralta.portalbdn.di.dataModule
import edu.jrubiralta.portalbdn.di.domainModule

class App
    : Application() {

    var kodein = Kodein { importDependencies(this) }

    fun importDependencies(kodeinBuilder: Kodein.Builder) {
        kodeinBuilder.import(appModule(this))
        kodeinBuilder.import(domainModule)
        kodeinBuilder.import(dataModule)
    }

}
