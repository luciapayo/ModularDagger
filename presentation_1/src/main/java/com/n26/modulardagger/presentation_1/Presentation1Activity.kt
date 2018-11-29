package com.n26.modulardagger.presentation_1

import android.os.Bundle
import com.n26.modulardagger.architecture_presentation.actiivty.BaseInjectingActivity
import kotlinx.android.synthetic.main.activity_presentation1.*

class Presentation1Activity : BaseInjectingActivity() {

//    @Inject
//    lateinit var retrieveDomainEntity1: RetrieveDomainEntity1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation1)
        //val entity = retrieveDomainEntity1.retrieveDomainEntity1()
        tv.setText("This is Presentation1")
    }
}
