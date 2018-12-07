package com.n26.modulardagger.domain_data_2.data

import com.n26.modulardagger.base.injection.UserSessionScope
import com.n26.modulardagger.base.network.Retrofit
import dagger.Module
import dagger.Provides

@Module
internal class Data2Module {

    @UserSessionScope
    @Provides
    fun provideRepository2(retrofit: Retrofit): Repository2 = Repository2(retrofit)
}
