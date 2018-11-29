package com.n26.modulardagger

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.HasGraphProvider
import javax.inject.Inject

class ModularDaggerApp : Application(), HasGraphProvider {

    @Inject
    lateinit var sp: SharedPreferences

    private val graph by lazy {
        GraphProvider()
    }

    override fun graphProvider(): GraphProvider = graph

    private val appComponent by lazy(LazyThreadSafetyMode.NONE) {
        graph.createInjector(DaggerAppComponent.builder().create(this))
    }

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
        Log.d("TAG", ">>> SP injected: ${sp.hashCode()}")
    }
}
