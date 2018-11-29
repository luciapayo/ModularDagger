package com.n26.modulardagger

import android.app.Application
import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.graph.Injector
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
internal interface AppComponent : Injector<ModularDaggerApp> {

    override fun inject(app: ModularDaggerApp)

    @Component.Builder
    interface Builder : Injector.Builder<ModularDaggerApp> {

        @BindsInstance
        fun create(app: Application): Builder

        override fun build(): AppComponent
    }
}