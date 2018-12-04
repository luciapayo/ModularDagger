package com.n26.modulardagger.base.injection

import android.app.Application
import android.content.SharedPreferences
import com.n26.modulardagger.base.injection.modules.AppModule
import com.n26.modulardagger.base.network.NetworkComponent
import com.n26.modulardagger.base.network.NetworkComponentCreator
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphCreator
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [AppModule::class], dependencies = [NetworkComponent::class])
abstract class BaseComponent : Graph {

    abstract fun providesSharedPrefs(): SharedPreferences

    @Component.Builder
    internal interface Builder : Graph.Builder {

        @BindsInstance
        fun bind(app: Application): Builder

        fun networkComponent(networkComponent: NetworkComponent): Builder

        override fun build(): BaseComponent
    }
}

class BaseComponentCreator(private val app: Application) : GraphCreator {

    override fun create(): BaseComponent =
        DaggerBaseComponent
            .builder()
            .bind(app)
            .networkComponent(NetworkComponentCreator().create())
            .build()
}
