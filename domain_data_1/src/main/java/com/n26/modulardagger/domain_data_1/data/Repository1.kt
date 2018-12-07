package com.n26.modulardagger.domain_data_1.data

import com.n26.modulardagger.base.network.Retrofit
import com.n26.modulardagger.domain_data_1.domain.DomainEntity1

class Repository1(private val retrofit: Retrofit) {

    val data by lazy {
        DomainEntity1("This is DomainEntity1")
    }
}
