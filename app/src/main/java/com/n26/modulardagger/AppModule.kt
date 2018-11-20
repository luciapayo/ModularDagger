package com.n26.modulardagger

import android.content.Context
import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.base.injection.ForApplication
import dagger.Module
import dagger.Provides

@Module
internal class AppModule(private val context: Context) {

    @AppScope
    @ForApplication
    @Provides
    fun provideAppContext(): Context = context
}
