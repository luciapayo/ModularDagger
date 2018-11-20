package com.n26.modulardagger

import android.app.Application

class ModularDaggerApp : Application() {

    private val appComponent by lazy(LazyThreadSafetyMode.NONE) {
        createAppComponent()
    }

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
    }
}
