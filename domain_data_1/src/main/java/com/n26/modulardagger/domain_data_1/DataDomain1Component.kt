package com.n26.modulardagger.domain_data_1

import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.BaseComponentProvider
import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.domain_data_1.data.Data1Module
import com.n26.modulardagger.domain_data_1.data.Repository1
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
import dagger.Component
import kotlin.reflect.KClass

@AppScope
@Component(dependencies = [BaseComponent::class], modules = [Data1Module::class])
interface DataDomain1Component : Graph {

    fun provideRepository1(): Repository1

    @Component.Builder
    interface Builder {

        fun baseComponent(component: BaseComponent): Builder

        fun build(): DataDomain1Component
    }
}

class DataDomain1ComponentProvider : GraphProvider<DaggerDataDomain1Component>() {

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.APP

    override fun createGraph(): Graph =
        DaggerDataDomain1Component.builder()
            .baseComponent(BaseComponentProvider().provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerDataDomain1Component> = DaggerDataDomain1Component::class
}
