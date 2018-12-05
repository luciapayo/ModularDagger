package com.n26.modulardagger

import android.app.Application
import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.DaggerBaseComponentProvider
import com.n26.modulardagger.graph.AppScope
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.ScopePolicy
import dagger.Component
import kotlin.reflect.KClass

@AppScope
@Component(dependencies = [BaseComponent::class])
interface AppComponent : Graph {

    fun inject(app: ModularDaggerApp)

    @Component.Builder
    interface Builder : Graph.Builder {

        fun baseComponent(component: BaseComponent): Builder

        override fun build(): AppComponent
    }
}

class DaggerAppComponentProvider(private val app: Application) : GraphProvider<DaggerAppComponent>() {

    override fun scopePolicy(): ScopePolicy = ScopePolicy.NO_POLICY

    override fun createGraph(): AppComponent =
        DaggerAppComponent
            .builder()
            .baseComponent(DaggerBaseComponentProvider(app).provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerAppComponent> = DaggerAppComponent::class
}
