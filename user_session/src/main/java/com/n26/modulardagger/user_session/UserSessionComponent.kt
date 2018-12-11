package com.n26.modulardagger.user_session

import com.n26.modulardagger.base.injection.UserSessionScope
import com.n26.modulardagger.graph.Graph
import com.n26.modulardagger.graph.GraphProvider
import com.n26.modulardagger.graph.RetentionPolicy
import dagger.Component
import kotlin.reflect.KClass

@UserSessionScope
@Component
internal interface UserSessionComponent : Graph {

    fun inject(userSession: UserSession)

    @Component.Builder
    interface Builder {

        fun build(): UserSessionComponent
    }
}

internal class UserSessionComponentProvider : GraphProvider<DaggerUserSessionComponent>() {

    override fun retentionPolicy(): RetentionPolicy = RetentionPolicy.USER_SESSION

    override fun createGraph(): Graph =
        DaggerUserSessionComponent.builder()
            .build()

    override fun graphClass(): KClass<DaggerUserSessionComponent> =
        DaggerUserSessionComponent::class
}
