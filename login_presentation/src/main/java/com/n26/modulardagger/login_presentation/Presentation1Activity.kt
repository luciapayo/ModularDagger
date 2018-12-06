package com.n26.modulardagger.login_presentation

import android.os.Bundle
import com.n26.modulardagger.architecture_presentation.actiivty.BaseInjectingActivity
import com.n26.modulardagger.domain_data_1.domain.RetrieveDomainEntity1
import kotlinx.android.synthetic.main.activity_presentation1.*
import javax.inject.Inject

class Presentation1Activity : BaseInjectingActivity() {

    @Inject
    lateinit var retrieveDomainEntity1: RetrieveDomainEntity1

    override fun onCreate(savedInstanceState: Bundle?) {
        onInject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation1)
        //val entity = retrieveDomainEntity1.retrieveDomainEntity1()
        tv.setText("This is Presentation1 with repo: ${retrieveDomainEntity1.retrieveDomainEntity1()}")
    }

    private fun onInject() {
        DaggerPresentation1ActivityComponentProvider().provideGraph().inject(this)
    }
}
