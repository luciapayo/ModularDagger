package com.n26.modulardagger.base

import android.app.Application
import android.content.SharedPreferences
import com.n26.modulardagger.base.injection.modules.AppModule
import com.n26.modulardagger.base.network.NetworkModule
import com.n26.modulardagger.base.network.Retrofit
import com.n26.modulardagger.graph.AppScope
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
import dagger.BindsInstance
import dagger.Component
import kotlin.reflect.KClass

@AppScope
@Component(modules = [AppModule::class, NetworkModule::class])
interface BaseComponent : Graph {

    fun providesSharedPrefs(): SharedPreferences

    fun provideRetrofit(): Retrofit

    @Component.Builder
    interface Builder : Graph.Builder {

        @BindsInstance
        fun bind(app: Application): Builder

        override fun build(): BaseComponent
    }
}

class DaggerBaseComponentProvider(private val app: Application? = null) : GraphProvider<DaggerBaseComponent>() {

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.APP

    override fun createGraph(): BaseComponent =
        DaggerBaseComponent.builder()
            .bind(app.isNotNull())
            .build()

    override fun graphClass(): KClass<DaggerBaseComponent> = DaggerBaseComponent::class

    private fun Application?.isNotNull(): Application =
        this ?: throw IllegalStateException("Trying to create BaseComponent but app instance has not been passed!")
}
