package com.n26.modulardagger

import android.app.Application
import android.content.Context
import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.base.injection.ForApplication
import dagger.Module
import dagger.Provides

@Module
internal class AppModule {

    @AppScope
    @ForApplication
    @Provides
    fun provideAppContext(app: Application): Context = app.applicationContext
}
