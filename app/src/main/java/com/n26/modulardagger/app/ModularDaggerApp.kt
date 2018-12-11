package com.n26.modulardagger.app

import android.app.Application

class ModularDaggerApp : Application() {

    override fun onCreate() {
        AppComponentProvider(this).provideGraph().inject(this)
        super.onCreate()
    }
}
