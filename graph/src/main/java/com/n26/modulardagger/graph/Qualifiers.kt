package com.n26.modulardagger.graph

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ForApplication

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ForActivity
