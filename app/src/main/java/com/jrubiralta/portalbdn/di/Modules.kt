package com.jrubiralta.portalbdn.di

import android.content.Context
import com.github.salomonbrys.kodein.*
import com.jrubiralta.data.network.*
import com.jrubiralta.data.repository.IncidenciesRepositoryImpl
import com.jrubiralta.domain.interactor.incidencies.GetIncidenciesUseCase
import com.jrubiralta.domain.repository.IncidenciesRepository
import com.jrubiralta.portalbdn.BuildConfig
import com.jrubiralta.portalbdn.domain.constants.BuildType
import com.jrubiralta.portalbdn.domain.constants.buildType
import com.jrubiralta.portalbdn.domain.executor.Executor
import com.jrubiralta.portalbdn.executor.RxExecutor

/**
 * Modules
 */
fun appModule(context: Context) = Kodein.Module {

    bind<Context>() with singleton { context }
    bind<Executor>() with singleton { RxExecutor() }
    bind<BuildType>() with singleton { buildType(BuildConfig.BUILD_TYPE) }

}

val domainModule = Kodein.Module {
    bind() from provider { GetIncidenciesUseCase(repository = instance(), executor = instance()) }
}

val dataModule = Kodein.Module {
    //Preferences
    //Database
    //Api Services
    bind<Network>() with singleton {
        AppNetwork(
            apiService = createService(endPoint = ApiService.ENDPOINT_1, authInterceptor = BasicAuthInterceptor(), ignoreSSL = true)
        )
    }
    //Data sources
    //Repository
    bind<IncidenciesRepository>() with singleton { IncidenciesRepositoryImpl(network = instance()) }

}