package com.n26.modulardagger

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import com.n26.modulardagger.graph.Graph
import javax.inject.Inject

class ModularDaggerApp : Application() {

    @Inject
    lateinit var sp: SharedPreferences

    private val appComponent by lazy(LazyThreadSafetyMode.NONE) {
        AppComponentProvider(this).provideGraph()
    }

    override fun onCreate() {
        appComponent.inject(this)
        val graph = appComponent as Graph
        graph::class.java
        super.onCreate()
        Log.d("TAG", ">>> SP injected: ${sp.hashCode()}")
    }
}
