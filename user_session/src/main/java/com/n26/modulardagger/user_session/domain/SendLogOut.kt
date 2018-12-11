package com.n26.modulardagger.user_session.domain

import com.n26.modulardagger.graph.GraphStoreProvider.clearGraphStore
import com.n26.modulardagger.graph.RetentionPolicy
import javax.inject.Inject

class SendLogOut @Inject internal constructor() {

    fun sendLogOut() {
        // Does other things like release the UserSession object and clear its viewModel
        clearGraphStore(RetentionPolicy.USER_SESSION)
    }
}
