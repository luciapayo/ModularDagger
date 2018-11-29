package com.n26.modulardagger

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.HasGraph
import javax.inject.Inject

class ModularDaggerApp : Application(), HasGraph {

    @Inject
    lateinit var sp: SharedPreferences

    private val graph by lazy {
        Graph()
    }

    override fun graph(): Graph = graph

    private val appComponent by lazy(LazyThreadSafetyMode.NONE) {
        graph.createComponent(DaggerAppComponent.builder().create(this))
    }

    override fun onCreate() {
        appComponent.inject(this)
        super.onCreate()
        Log.d("TAG", ">>> SP injected: ${sp.hashCode()}")
    }
}
