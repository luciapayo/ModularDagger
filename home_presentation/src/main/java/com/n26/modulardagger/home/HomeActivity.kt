package com.n26.modulardagger.home

import android.os.Bundle
import com.n26.modulardagger.domain_data_1.domain.RetrieveDomainEntity1
import com.n26.modulardagger.domain_data_2.domain.RetrieveDomainEntity2
import com.n26.modulardagger.home.R.id.buttonLogOut
import com.n26.modulardagger.home.R.id.tv
import com.n26.modulardagger.user_session.domain.SendLogOut
import javax.inject.Inject

class HomeActivity : BaseInjectingActivity<HomeActivityComponent>() {

    @Inject
    lateinit var sendLogOut: SendLogOut

    @Inject
    lateinit var retrieveDomainEntity1: RetrieveDomainEntity1

    @Inject
    lateinit var retrieveDomainEntity2: RetrieveDomainEntity2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        tv.setText(
            "This is Home with:\n" +
                    "${retrieveDomainEntity1.retrieveDomainEntity1()}\n" +
                    "${retrieveDomainEntity2.retrieveDomainEntity2()}"
        )
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
