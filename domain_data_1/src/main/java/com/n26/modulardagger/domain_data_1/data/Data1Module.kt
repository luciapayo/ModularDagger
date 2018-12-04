package com.n26.modulardagger.domain_data_1.data

import dagger.Module
import dagger.Provides

@Module
class Data1Module {

    @Provides
    fun provideRepository1(): Repository1 = Repository1()
}
