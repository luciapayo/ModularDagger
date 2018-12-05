package com.n26.modulardagger

import android.app.Application
import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.BaseComponentProvider
import com.n26.modulardagger.graph.AppScope
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.ScopePolicy
import dagger.Component
import kotlin.reflect.KClass

@AppScope
@Component(dependencies = [BaseComponent::class])
internal interface AppComponent : Graph {

    fun inject(app: ModularDaggerApp)

    @Component.Builder
    interface Builder : Graph.Builder {

        fun baseComponent(component: BaseComponent): Builder

        override fun build(): AppComponent
    }
}

internal class AppComponentProvider(private val app: Application) : GraphProvider<AppComponent>() {

    override fun scopePolicy(): ScopePolicy = ScopePolicy.NO_POLICY

    override fun createGraph(): AppComponent =
        DaggerAppComponent
            .builder()
            .baseComponent(BaseComponentProvider(app).provideGraph())
            .build()

    override fun graphClass(): KClass<AppComponent> = AppComponent::class
}
