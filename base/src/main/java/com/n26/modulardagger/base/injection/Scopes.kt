package com.n26.modulardagger.base.injection

import javax.inject.Scope

/**
 * Definition of dagger scopes besides {@link Singleton} that is available by default.
 */
@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class AppScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class UserSessionScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class FragmentScope
