package com.n26.modulardagger.domain_data_1.domain

import com.n26.modulardagger.domain_data_1.data.Repository1
import javax.inject.Inject


class RetrieveDomainEntity1 @Inject internal constructor(private val repository: Repository1) {

    fun retrieveDomainEntity1() = repository.data
}
