package com.n26.modulardagger.login_presentation

import androidx.appcompat.app.AppCompatActivity
import com.n26.modulardagger.base.BaseComponent
import com.n26.modulardagger.base.DaggerBaseComponentProvider
import com.n26.modulardagger.base.injection.ActivityScope
import com.n26.modulardagger.base.injection.modules.ActivityModule
import com.n26.modulardagger.base.isNotNull
import com.n26.modulardagger.domain_data_1.DaggerDataDomain1ComponentProvider
import com.n26.modulardagger.domain_data_1.DataDomain1Component
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
import dagger.BindsInstance
import dagger.Component
import kotlin.reflect.KClass

@ActivityScope
@Component(dependencies = [DataDomain1Component::class, BaseComponent::class], modules = [ActivityModule::class])
interface Presentation1ActivityComponent : Graph {

    fun inject(activity: Presentation1Activity)

    @Component.Builder
    interface Builder : Graph.Builder {

        @BindsInstance
        fun bind(activity: AppCompatActivity): Builder

        fun dataDomain1Component(component: DataDomain1Component): Builder

        fun baseComponent(component: BaseComponent): Builder

        override fun build(): Presentation1ActivityComponent
    }
}

class DaggerPresentation1ActivityComponentProvider(private val activity: AppCompatActivity? = null) :
    GraphProvider<DaggerPresentation1ActivityComponent>() {

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.NO_POLICY

    override fun createGraph(): Presentation1ActivityComponent =
        DaggerPresentation1ActivityComponent.builder()
            .bind(activity.isNotNull())
            .dataDomain1Component(DaggerDataDomain1ComponentProvider().provideGraph())
            .baseComponent(DaggerBaseComponentProvider().provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerPresentation1ActivityComponent> =
        DaggerPresentation1ActivityComponent::class
}
