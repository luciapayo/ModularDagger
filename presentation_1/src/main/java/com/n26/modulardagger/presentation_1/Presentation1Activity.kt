package com.n26.modulardagger.presentation_1

import android.os.Bundle
import com.n26.modulardagger.architecture_presentation.actiivty.BaseInjectingActivity
import com.n26.modulardagger.domain_data_1.data.Repository1
import kotlinx.android.synthetic.main.activity_presentation1.*
import javax.inject.Inject

class Presentation1Activity : BaseInjectingActivity() {

    @Inject
    lateinit var repository1: Repository1

    override fun onCreate(savedInstanceState: Bundle?) {
        onInject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation1)
        //val entity = retrieveDomainEntity1.retrieveDomainEntity1()
        tv.setText("This is Presentation1 with repo: ${repository1.hashCode()}")
    }

    private fun onInject() {
        DaggerPresentation1ActivityComponentProvider().provideGraph().inject(this)
    }
}
