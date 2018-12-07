package com.n26.modulardagger.home

import android.os.Bundle
import com.n26.modulardagger.architecture_presentation.actiivty.BaseInjectingActivity
import com.n26.modulardagger.user_session.domain.SendLogOut
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseInjectingActivity<HomeActivityComponent>() {

    @Inject
    lateinit var sendLogOut: SendLogOut

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        buttonLogOut.setOnClickListener { logOut() }
    }

    private fun logOut() {
        sendLogOut.sendLogOut()
        finish()
    }

    override fun createGraph(): HomeActivityComponent =
        HomeActivityComponentProvider(this).provideGraph()

    override fun onInject(graph: HomeActivityComponent) = graph.inject(this)
}
