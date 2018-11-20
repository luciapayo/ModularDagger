package com.n26.modulardagger

import android.app.Application
import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.presentation1.Presentation1ActivityModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [AppModule::class, Presentation1ActivityModule::class])
internal interface AppComponent {

    fun inject(app: ModularDaggerApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }
}

internal fun createAppComponent(app: Application) =
    DaggerAppComponent.builder()
        .create(app)
        .build()