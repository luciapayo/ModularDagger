package com.n26.modulardagger.user_session

import com.n26.modulardagger.base.injection.UserSessionScope
import javax.inject.Inject

@UserSessionScope
class UserSessionViewModel @Inject constructor() {

    fun onBind() {
        // Do user session global things
    }

    fun onCleared() {

    }
}
