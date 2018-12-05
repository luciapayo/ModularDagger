package com.n26.modulardagger.domain_data_1.data

import com.n26.modulardagger.base.network.Retrofit
import com.n26.modulardagger.graph.AppScope
import dagger.Module
import dagger.Provides

@Module
class Data1Module {

    @AppScope
    @Provides
    fun provideRepository1(retrofit: Retrofit): Repository1 = Repository1(retrofit)
}
