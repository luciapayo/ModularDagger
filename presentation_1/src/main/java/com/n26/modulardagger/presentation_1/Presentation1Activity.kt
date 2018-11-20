package com.n26.modulardagger.presentation_1

import android.content.SharedPreferences
import android.os.Bundle
import com.n26.modulardagger.architecture_presentation.actiivty.BaseInjectingActivity
import javax.inject.Inject

class Presentation1Activity : BaseInjectingActivity() {

    @Inject
    lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation1)
    }
}
