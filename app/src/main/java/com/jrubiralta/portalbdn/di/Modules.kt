package com.jrubiralta.portalbdn.di

import android.content.Context
import com.github.salomonbrys.kodein.*
import com.jrubiralta.data.network.*
import com.jrubiralta.data.persistence.PortalPreferences
import com.jrubiralta.data.repository.IncidenciesRepositoryImpl
import com.jrubiralta.data.repository.UserRepositoryImpl
import com.jrubiralta.domain.interactor.incidencies.GetIncidenciesUseCase
import com.jrubiralta.domain.interactor.user.SignInUseCase
import com.jrubiralta.domain.interactor.user.SignUpUseCase
import com.jrubiralta.domain.repository.IncidenciesRepository
import com.jrubiralta.domain.repository.UserRepository
import com.jrubiralta.portalbdn.BuildConfig
import com.jrubiralta.portalbdn.domain.constants.BuildType
import com.jrubiralta.portalbdn.domain.constants.Constants
import com.jrubiralta.portalbdn.domain.constants.buildType
import com.jrubiralta.portalbdn.domain.executor.Executor
import com.jrubiralta.portalbdn.executor.RxExecutor
import com.jrubiralta.portalbdn.persistence.Persistence

/**
 * Modules
 */
fun appModule(context: Context) = Kodein.Module {

    bind<Context>() with singleton { context }
    bind<Executor>() with singleton { RxExecutor() }
    bind<BuildType>() with singleton { buildType(BuildConfig.BUILD_TYPE) }

}

val domainModule = Kodein.Module {
    bind() from provider { SignInUseCase(repository = instance(), executor = instance()) }
    bind() from provider { SignUpUseCase(repository = instance(), executor = instance()) }
    bind() from provider { GetIncidenciesUseCase(repository = instance(), executor = instance()) }
}

val dataModule = Kodein.Module {
    //Preferences
    bind<Persistence>() with singleton {
        PortalPreferences(context = instance(), name = Constants.preferencesName(buildType = instance()))
    }

    //Database
    //Api Services
    bind<Network>() with singleton {
        AppNetwork(
            apiService = createService(endPoint = ApiService.ENDPOINT_1, authInterceptor = BasicAuthInterceptor(), ignoreSSL = true)
        )
    }
    //Data sources
    //Repository
    bind<UserRepository>() with singleton { UserRepositoryImpl(network = instance(), persistence = instance()) }
    bind<IncidenciesRepository>() with singleton { IncidenciesRepositoryImpl(network = instance(), persistence = instance()) }

}