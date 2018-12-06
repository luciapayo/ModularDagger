package com.n26.modulardagger.app

import android.app.Application
import com.n26.modulardagger.DaggerAppComponent
import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.DaggerBaseComponentProvider
import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
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

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.NO_POLICY

    override fun createGraph(): AppComponent =
        DaggerAppComponent.builder()
            .baseComponent(DaggerBaseComponentProvider(app).provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerAppComponent> = DaggerAppComponent::class
}
