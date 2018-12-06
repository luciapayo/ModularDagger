package com.n26.modulardagger.architecture_presentation.actiivty

import android.os.Bundle
import com.n26.modulardagger.graph.Graph

abstract class BaseInjectingActivity<G : Graph> : BaseActivity() {

    protected val component: G by lazy(LazyThreadSafetyMode.NONE) {
        createGraph()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        onInject(component)
        super.onCreate(savedInstanceState)
    }

    protected abstract fun createGraph(): G

    protected abstract fun onInject(graph: G)
}
