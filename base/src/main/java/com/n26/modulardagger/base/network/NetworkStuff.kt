package com.n26.modulardagger.base.network

import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphCreator
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

class Retrofit

@Module
internal class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() = Retrofit()
}

@Singleton
@Component(modules = [NetworkModule::class])
internal interface NetworkComponent : Graph {

    fun retrofit(): Retrofit

    @Component.Builder
    interface Builder : Graph.Builder {

        override fun build(): NetworkComponent
    }
}

internal class NetworkComponentCreator : GraphCreator {

    override fun create(): NetworkComponent =
        DaggerNetworkComponent
            .builder()
            .build()
}
