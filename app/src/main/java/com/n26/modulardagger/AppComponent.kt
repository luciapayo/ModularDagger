package com.n26.modulardagger

import android.app.Application
import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.BaseComponentCreator
import com.n26.modulardagger.graph.AppScope
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphCreator
import com.n26.modulardagger.graph.GraphProvider
import dagger.Component

@AppScope
@Component(dependencies = [BaseComponent::class])
internal abstract class AppComponent : Graph {

    abstract fun inject(app: ModularDaggerApp)

    @Component.Builder
    interface Builder : Graph.Builder {

        fun baseComponent(component: BaseComponent): Builder

        override fun build(): AppComponent
    }
}

internal class AppComponentCreator(private val app: Application) : GraphCreator {

    override fun create(): AppComponent {
        val component = GraphProvider.getGraph(AppComponent::class)
            ?: createInternal()

        return component as AppComponent
    }

    private fun createInternal(): AppComponent {
        val component = DaggerAppComponent
            .builder()
            .baseComponent(BaseComponentCreator(app).create())
            .build()
        GraphProvider.storeGraph(component)
        return component
    }
}
