package com.n26.modulardagger.base.network

import com.n26.modulardagger.base.injection.AppScope
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @AppScope
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit()
}