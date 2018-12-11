package com.n26.modulardagger.domain_3

import com.n26.modulardagger.domain_data_1.DataDomain1Component
import com.n26.modulardagger.domain_data_1.DataDomain1ComponentProvider
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
import com.n26.modulardagger.legacy.LegacyComponent
import com.n26.modulardagger.legacy.LegacyComponentProvider
import dagger.Component
import kotlin.reflect.KClass

@Component(dependencies = [LegacyComponent::class, DataDomain1Component::class])
interface Domain3Component : Graph {

    @Component.Builder
    interface Builder : Graph.Builder {

        fun legacyComponent(component: LegacyComponent): Builder
        fun dataDomain1Component(component: DataDomain1Component): Builder

        override fun build(): Domain3Component
    }
}

class Domain3ComponentProvider : GraphProvider<DaggerDomain3Component>() {

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.NO_POLICY

    override fun createGraph(): Graph =
        DaggerDomain3Component.builder()
            .dataDomain1Component(DataDomain1ComponentProvider().provideGraph())
            .legacyComponent(LegacyComponentProvider().provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerDomain3Component> = DaggerDomain3Component::class
}
