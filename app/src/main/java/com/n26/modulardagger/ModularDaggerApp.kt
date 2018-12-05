package com.n26.modulardagger

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import javax.inject.Inject

class ModularDaggerApp : Application() {

    @Inject
    lateinit var sp: SharedPreferences

    override fun onCreate() {
        DaggerAppComponentProvider(this).provideGraph().inject(this)
        super.onCreate()
        Log.d("TAG", ">>> SP injected: ${sp.hashCode()}")
    }
}
