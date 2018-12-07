package com.n26.modulardagger.user_session

import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.graph.GraphStoreProvider.clearGraphStore
import com.n26.modulardagger.graph.RetentionPolicy
import javax.inject.Inject

@AppScope
internal class UserSessionHandler @Inject constructor() {

    private var userSession: UserSession? = null

    fun startSession() {
        userSession = UserSession()
        userSession?.onCreate()
    }

    fun finaliseSession() {
        clearGraphStore(RetentionPolicy.USER_SESSION)
        userSession?.onDestroy()
        userSession = null
    }
}
