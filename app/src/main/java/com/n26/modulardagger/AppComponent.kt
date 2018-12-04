package com.n26.modulardagger

import android.app.Application
import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.BaseComponentCreator
import com.n26.modulardagger.graph.AppScope
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphCreator
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

    override fun create(): Graph =
        DaggerAppComponent
            .builder()
            .baseComponent(BaseComponentCreator(app).create())
            .build()
}
