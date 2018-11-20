package com.n26.modulardagger.architecture_presentation.actiivty

import android.os.Bundle
import dagger.android.AndroidInjection

abstract class BaseInjectingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}