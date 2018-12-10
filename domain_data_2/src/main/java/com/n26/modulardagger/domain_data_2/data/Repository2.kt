package com.n26.modulardagger.domain_data_2.data

import com.n26.modulardagger.base.network.Retrofit
import com.n26.modulardagger.domain_data_2.domain.DomainEntity2
import java.util.*

class Repository2(private val retrofit: Retrofit) {

    val data: DomainEntity2 = DomainEntity2(Random().nextInt(1000))
}
