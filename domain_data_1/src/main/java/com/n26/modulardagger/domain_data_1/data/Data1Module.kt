package com.n26.modulardagger.domain_data_1.data

import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.base.network.Retrofit
import dagger.Module
import dagger.Provides

@Module
internal class Data1Module {

    @AppScope
    @Provides
    fun provideRepository1(retrofit: Retrofit): Repository1 = Repository1(retrofit)
}
