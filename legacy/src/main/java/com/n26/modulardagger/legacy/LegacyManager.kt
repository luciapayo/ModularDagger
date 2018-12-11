package com.n26.modulardagger.legacy

import com.n26.modulardagger.base.network.Retrofit
import java.util.*

class LegacyManager(private val retrofit: Retrofit) {

    val legacyState = LegacyEntity(Random().nextInt(1000))
}