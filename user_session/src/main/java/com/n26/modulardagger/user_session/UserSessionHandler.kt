package com.n26.modulardagger.user_session

import android.util.Log
import com.n26.modulardagger.base.injection.AppScope
import com.n26.modulardagger.graph.GraphStoreProvider.clearGraphStore
import com.n26.modulardagger.graph.RetentionPolicy
import javax.inject.Inject

@AppScope
class UserSessionHandler @Inject constructor() {

    private var userSession: UserSession? = null

    fun startSession() {
        Log.d("UserSessionHandler", ">>>> startSession(): ${this.hashCode()}")
        userSession = UserSession()
        userSession?.onCreate()
    }

    fun finaliseSession() {
        Log.d("UserSessionHandler", ">>>> finaliseSession(): ${this.hashCode()}")
        clearGraphStore(RetentionPolicy.USER_SESSION)
        userSession?.onDestroy()
        userSession = null
    }
}
