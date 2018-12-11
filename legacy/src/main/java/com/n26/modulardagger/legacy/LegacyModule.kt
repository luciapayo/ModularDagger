package com.n26.modulardagger.legacy

import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.base.network.Retrofit
import dagger.Module
import dagger.Provides

@Module
internal class LegacyModule {

    @AppScope
    @Provides
    fun provideLegacyManager(retrofit: Retrofit) = LegacyManager(retrofit)
}
