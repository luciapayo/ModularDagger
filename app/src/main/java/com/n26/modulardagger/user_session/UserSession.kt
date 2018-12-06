package com.n26.modulardagger.user_session

class UserSession {

    fun onCreate() {
        DaggerUserSessionComponentProvider().provideGraph().inject(this)
    }

    fun onDestroy() {

    }
}