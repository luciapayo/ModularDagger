package com.n26.modulardagger.domain_data_1.data

import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.domain_data_1.domain.DomainEntity1
import javax.inject.Inject

@AppScope
internal class Repository1 @Inject constructor() {

    val data by lazy(LazyThreadSafetyMode.NONE) {
        DomainEntity1("This is DomainEntity1")
    }
}
