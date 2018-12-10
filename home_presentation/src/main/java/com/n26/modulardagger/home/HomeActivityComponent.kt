package com.n26.modulardagger.home

import androidx.appcompat.app.AppCompatActivity
import com.n26.modulardagger.base.injection.ActivityScope
import com.n26.modulardagger.base.injection.modules.ActivityModule
import com.n26.modulardagger.base.isNotNull
import com.n26.modulardagger.domain_data_1.DataDomain1Component
import com.n26.modulardagger.domain_data_1.DataDomain1ComponentProvider
import com.n26.modulardagger.domain_data_2.DataDomain2Component
import com.n26.modulardagger.domain_data_2.DataDomain2ComponentProvider
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
import dagger.BindsInstance
import dagger.Component
import kotlin.reflect.KClass

@ActivityScope
@Component(dependencies = [DataDomain2Component::class, DataDomain1Component::class], modules = [ActivityModule::class])
interface HomeActivityComponent : Graph {

    fun inject(activity: HomeActivity)

    @Component.Builder
    interface Builder : Graph.Builder {

        @BindsInstance
        fun bind(activity: AppCompatActivity): Builder

        fun dataDomain1Component(component: DataDomain1Component): Builder
        fun dataDomain2Component(component: DataDomain2Component): Builder

        override fun build(): HomeActivityComponent
    }
}

class HomeActivityComponentProvider(private val activity: AppCompatActivity? = null) :
    GraphProvider<DaggerHomeActivityComponent>() {

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.NO_POLICY

    override fun createGraph(): Graph =
        DaggerHomeActivityComponent.builder()
            .bind(activity.isNotNull())
            .dataDomain1Component(DataDomain1ComponentProvider().provideGraph())
            .dataDomain2Component(DataDomain2ComponentProvider().provideGraph())
            .build()

    override fun graphClass(): KClass<DaggerHomeActivityComponent> = DaggerHomeActivityComponent::class
}
