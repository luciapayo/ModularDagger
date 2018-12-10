package com.n26.modulardagger.login_presentation

import androidx.appcompat.app.AppCompatActivity
import com.n26.modulardagger.base.injection.ActivityScope
import com.n26.modulardagger.base.injection.modules.ActivityModule
import com.n26.modulardagger.base.isNotNull
import com.n26.modulardagger.domain_data_1.DataDomain1Component
import com.n26.modulardagger.domain_data_1.DataDomain1ComponentProvider
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
import dagger.BindsInstance
import dagger.Component
import kotlin.reflect.KClass

@ActivityScope
@Component(dependencies = [DataDomain1Component::class], modules = [ActivityModule::class])
interface LoginActivityComponent : Graph {

    fun inject(activity: LoginActivity)

    @Component.Builder
    interface Builder : Graph.Builder {

        @BindsInstance
        fun bind(activity: AppCompatActivity): Builder

        fun dataDomain1Component(component: DataDomain1Component): Builder

        override fun build(): LoginActivityComponent
    }
}

class Presentation1ActivityComponentProvider(private val activity: AppCompatActivity? = null) :
    GraphProvider<DaggerLoginActivityComponent>() {

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.NO_POLICY

    override fun createGraph(): Graph =
        DaggerLoginActivityComponent.builder()
            .bind(activity.isNotNull())
            .dataDomain1Component(DataDomain1ComponentProvider().provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerLoginActivityComponent> =
        DaggerLoginActivityComponent::class
}
