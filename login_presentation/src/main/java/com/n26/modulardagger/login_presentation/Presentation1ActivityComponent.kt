package com.n26.modulardagger.login_presentation

import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.DaggerBaseComponentProvider
import com.n26.modulardagger.base.injection.modules.ActivityScope
import com.n26.modulardagger.domain_data_1.DaggerDataDomain1ComponentProvider
import com.n26.modulardagger.domain_data_1.DataDomain1Component
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
import dagger.Component
import kotlin.reflect.KClass

@ActivityScope
@Component(dependencies = [DataDomain1Component::class, BaseComponent::class])
interface Presentation1ActivityComponent : Graph {

    fun inject(activity: Presentation1Activity)

    @Component.Builder
    interface Builder : Graph.Builder {

        fun dataDomain1Component(component: DataDomain1Component): Builder

        fun baseComponent(component: BaseComponent): Builder

        override fun build(): Presentation1ActivityComponent
    }
}

class DaggerPresentation1ActivityComponentProvider : GraphProvider<DaggerPresentation1ActivityComponent>() {

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.NO_POLICY

    override fun createGraph(): Presentation1ActivityComponent =
        DaggerPresentation1ActivityComponent.builder()
            .dataDomain1Component(DaggerDataDomain1ComponentProvider().provideGraph())
            .baseComponent(DaggerBaseComponentProvider().provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerPresentation1ActivityComponent> =
        DaggerPresentation1ActivityComponent::class
}
