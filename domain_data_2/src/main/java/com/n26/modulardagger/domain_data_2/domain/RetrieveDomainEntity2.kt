package com.n26.modulardagger.domain_data_2.domain

import com.n26.modulardagger.domain_data_2.data.Repository2
import javax.inject.Inject

class RetrieveDomainEntity2 @Inject internal constructor(private val repository: Repository2) {

    fun retrieveDomainEntity2() = repository.data
}