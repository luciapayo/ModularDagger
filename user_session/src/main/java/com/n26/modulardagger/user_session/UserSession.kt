package com.n26.modulardagger.user_session

import android.util.Log
import javax.inject.Inject

internal class UserSession {

    @Inject
    lateinit var viewModel: UserSessionViewModel

    fun onCreate() {
        UserSessionComponentProvider().provideGraph().inject(this)
        Log.d("UserSession", "ViewModel: ${viewModel.hashCode()}")
        // Do common things for the session.
    }

    fun onDestroy() {

    }
}
