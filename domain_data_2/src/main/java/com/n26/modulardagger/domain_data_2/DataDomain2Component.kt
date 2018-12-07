package com.n26.modulardagger.domain_data_2

import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.BaseComponentProvider
import com.n26.modulardagger.base.injection.UserSessionScope
import com.n26.modulardagger.domain_data_2.data.Data2Module
import com.n26.modulardagger.domain_data_2.data.Repository2
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
import dagger.Component
import kotlin.reflect.KClass

@UserSessionScope
@Component(dependencies = [BaseComponent::class], modules = [Data2Module::class])
interface DataDomain2Component : Graph {

    fun provideRepository2(): Repository2

    @Component.Builder
    interface Builder : Graph.Builder {

        fun baseComponent(component: BaseComponent): Builder

        override fun build(): DataDomain2Component
    }
}

class DataDomain2ComponentProvider : GraphProvider<DaggerDataDomain2Component>() {
    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.USER_SESSION

    override fun createGraph(): Graph =
        DaggerDataDomain2Component.builder()
            .baseComponent(BaseComponentProvider().provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerDataDomain2Component> =
        DaggerDataDomain2Component::class
}
