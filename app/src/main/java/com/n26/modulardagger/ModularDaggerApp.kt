package com.n26.modulardagger

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class ModularDaggerApp : Application(), HasActivityInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = androidInjector

    private val appComponent by lazy(LazyThreadSafetyMode.NONE) {
        createAppComponent(this)
    }

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
    }
}
