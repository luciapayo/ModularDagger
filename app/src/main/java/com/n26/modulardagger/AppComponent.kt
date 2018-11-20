package com.n26.modulardagger

import com.n26.modulardagger.base.injection.AppScope
import dagger.Component

@AppScope
@Component
internal interface AppComponent {

    fun inject(app: ModularDaggerApp)
}

internal fun createAppComponent() =
    DaggerAppComponent.builder().build() ?: throw IllegalStateException("AppComponent creation failed!")