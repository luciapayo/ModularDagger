package com.n26.modulardagger.base.injection.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
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

    @AppScope
    @Provides
    fun provideSharedPrefs(app: Application): SharedPreferences =
        app.getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
}
