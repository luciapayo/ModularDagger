package com.n26.modulardagger.base.network

import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.ScopePolicy
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.reflect.KClass

class Retrofit

@Module
internal class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() = Retrofit()
}

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent : Graph {

    fun retrofit(): Retrofit

    @Component.Builder
    interface Builder : Graph.Builder {

        override fun build(): NetworkComponent
    }
}

internal class NetworkComponentProvider : GraphProvider<NetworkComponent>() {

    override fun scopePolicy(): ScopePolicy = ScopePolicy.APP

    override fun createGraph(): NetworkComponent = DaggerNetworkComponent.create()

    override fun graphClass(): KClass<NetworkComponent> = NetworkComponent::class
}
