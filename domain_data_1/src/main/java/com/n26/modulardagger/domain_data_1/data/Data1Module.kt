package com.n26.modulardagger.domain_data_1.data

import com.n26.modulardagger.base.injection.AppScope
import dagger.Module
import dagger.Provides

@Module
class Data1Module {

    @AppScope
    @Provides
    fun provideRepository1(): Repository1 = Repository1()
}
