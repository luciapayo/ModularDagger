package com.n26.modulardagger.domain_3.domain

import com.n26.modulardagger.domain_data_1.data.Repository1
import com.n26.modulardagger.legacy.LegacyManager
import javax.inject.Inject

class RetrieveDomainEntity3 @Inject internal constructor(
    private val repository1: Repository1,
    private val legacyManager: LegacyManager
) {

    fun retrieveDomainEntity3() =
        DomainEntity3(repository1.data.random + legacyManager.legacyState.random)
}