package com.n26.modulardagger.home

import android.os.Bundle
import com.n26.modulardagger.architecture_presentation.actiivty.BaseInjectingActivity

class HomeActivity : BaseInjectingActivity<HomeActivityComponent>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun createGraph(): HomeActivityComponent =
        DaggerHomeActivityComponentProvider(this).provideGraph()

    override fun onInject(graph: HomeActivityComponent) = graph.inject(this)
}
