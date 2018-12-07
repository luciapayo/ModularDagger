package com.n26.modulardagger.login_presentation

import android.content.Intent
import android.os.Bundle
import com.n26.modulardagger.architecture_presentation.actiivty.BaseInjectingActivity
import com.n26.modulardagger.domain_data_1.domain.RetrieveDomainEntity1
import com.n26.modulardagger.home.HomeActivity
import com.n26.modulardagger.user_session.domain.SendLogIn
import kotlinx.android.synthetic.main.activity_presentation1.*
import javax.inject.Inject

class Presentation1Activity : BaseInjectingActivity<Presentation1ActivityComponent>() {

    @Inject
    lateinit var retrieveDomainEntity1: RetrieveDomainEntity1

    @Inject
    lateinit var sendLogIn: SendLogIn

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation1)
        tv.setText("This is Presentation1 with repo: ${retrieveDomainEntity1.retrieveDomainEntity1()}")
        buttonLogin.setOnClickListener { logIn() }
    }

    private fun logIn() {
        sendLogIn.sendLogIn()
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun onInject(graph: Presentation1ActivityComponent) = graph.inject(this)

    override fun createGraph(): Presentation1ActivityComponent =
        Presentation1ActivityComponentProvider(this).provideGraph()
}
