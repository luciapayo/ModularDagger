package com.n26.modulardagger.base

import android.app.Application
import android.content.SharedPreferences
import com.n26.modulardagger.base.injection.modules.AppModule
import com.n26.modulardagger.base.network.NetworkComponent
import com.n26.modulardagger.base.network.NetworkComponentProvider
import com.n26.modulardagger.graph.AppScope
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.ScopePolicy
import dagger.BindsInstance
import dagger.Component
import kotlin.reflect.KClass

@AppScope
@Component(modules = [AppModule::class], dependencies = [NetworkComponent::class])
interface BaseComponent : Graph {

    fun providesSharedPrefs(): SharedPreferences

    @Component.Builder
    interface Builder : Graph.Builder {

        @BindsInstance
        fun bind(app: Application): Builder

        fun networkComponent(networkComponent: NetworkComponent): Builder

        override fun build(): BaseComponent
    }
}

class BaseComponentProvider(private val app: Application) : GraphProvider<BaseComponent>() {

    override fun scopePolicy(): ScopePolicy = ScopePolicy.APP

    override fun createGraph(): BaseComponent =
        DaggerBaseComponent.builder()
            .bind(app)
            .networkComponent(NetworkComponentProvider().provideGraph())
            .build()

    override fun graphClass(): KClass<BaseComponent> = BaseComponent::class
}
