package com.n26.modulardagger.app

import android.app.Application
import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.BaseComponentProvider
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

class AppComponentProvider(private val app: Application) : GraphProvider<DaggerAppComponent>() {

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.NO_POLICY

    override fun createGraph(): Graph =
        DaggerAppComponent.builder()
            .baseComponent(BaseComponentProvider(app).provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerAppComponent> = DaggerAppComponent::class
}
