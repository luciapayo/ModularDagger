package com.n26.modulardagger.app

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import com.n26.modulardagger.user_session.UserSessionHandler
import javax.inject.Inject

class ModularDaggerApp : Application() {

    @Inject
    lateinit var sp: SharedPreferences

    @Inject
    lateinit var userSessionHandler: UserSessionHandler

    override fun onCreate() {
        AppComponentProvider(this).provideGraph().inject(this)
        super.onCreate()
        Log.d("TAG", ">>> SessionHandler injected: ${userSessionHandler.hashCode()}")
    }
}
