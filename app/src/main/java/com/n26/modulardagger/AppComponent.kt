package com.n26.modulardagger

import android.content.Context
import com.n26.modulardagger.base.injection.AppScope
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
internal interface AppComponent {

    fun inject(app: ModularDaggerApp)
}

internal fun createAppComponent(appContext: Context) =
    DaggerAppComponent.builder()
        .appModule(AppModule(appContext))
        .build()
        ?: throw IllegalStateException("AppComponent creation failed!")