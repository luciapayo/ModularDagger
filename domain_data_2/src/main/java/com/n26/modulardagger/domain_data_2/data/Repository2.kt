package com.n26.modulardagger.domain_data_2.data

import com.n26.modulardagger.base.network.Retrofit
import com.n26.modulardagger.domain_data_2.domain.DomainEntity2

class Repository2(private val retrofit: Retrofit) {

    val data by lazy {
        DomainEntity2("This is DomainEntity2")
    }
}
