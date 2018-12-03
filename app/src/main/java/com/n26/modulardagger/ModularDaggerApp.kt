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

    private val graphProvider by lazy {
        GraphProvider()
    }

    override fun graphProvider(): GraphProvider = graphProvider

    private val appComponent by lazy(LazyThreadSafetyMode.NONE) {
        graphProvider.createGraph(AppComponentCreator(this)) as AppComponent
    }

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
        Log.d("TAG", ">>> SP injected: ${sp.hashCode()}")
    }
}

