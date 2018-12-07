package com.n26.modulardagger.user_session.domain

import com.n26.modulardagger.user_session.UserSessionHandler
import javax.inject.Inject

class SendLogOut @Inject internal constructor(private val sessionHandler: UserSessionHandler) {

    fun sendLogOut() {
        sessionHandler.finaliseSession()
    }
}
