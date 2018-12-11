package com.n26.modulardagger.legacy

import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.BaseComponentProvider
import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
import dagger.Component
import kotlin.reflect.KClass

@AppScope
@Component(modules = [LegacyModule::class], dependencies = [BaseComponent::class])
interface LegacyComponent : Graph {

    fun legacyManager(): LegacyManager

    @Component.Builder
    interface Builder : Graph.Builder {

        fun baseComponent(baseComponent: BaseComponent): Builder

        override fun build(): LegacyComponent
    }
}

class LegacyComponentProvider : GraphProvider<DaggerLegacyComponent>() {

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.APP

    override fun createGraph(): Graph =
        DaggerLegacyComponent.builder()
            .baseComponent(BaseComponentProvider().provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerLegacyComponent> = DaggerLegacyComponent::class
}
