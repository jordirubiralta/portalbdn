package edu.jrubiralta.portalbdn.di

import android.content.Context
import com.github.salomonbrys.kodein.*
import edu.jrubiralta.portalbdn.BuildConfig
import edu.jrubiralta.portalbdn.domain.constants.BuildType
import edu.jrubiralta.portalbdn.domain.constants.buildType
import edu.jrubiralta.portalbdn.domain.executor.Executor
import edu.jrubiralta.portalbdn.executor.RxExecutor
import edu.jrubiralta.portalbdn.persistence.Persistence

/**
 * Modules
 */
fun appModule(context: Context) = Kodein.Module {

    bind<Context>() with singleton { context }
    bind<Executor>() with singleton { RxExecutor() }
    bind<BuildType>() with singleton { buildType(BuildConfig.BUILD_TYPE) }

}

val domainModule = Kodein.Module {

}

val dataModule = Kodein.Module {
    //Preferences
    //Database
    // Api Services
    //Data sources
    //Repository
}