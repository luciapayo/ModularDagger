package com.n26.modulardagger.base.injection.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.n26.modulardagger.base.injection.ForActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @ForActivity
    @Provides
    fun provideContext(activity: AppCompatActivity): Context = activity

    @Provides
    fun provideActivity(activity: AppCompatActivity): AppCompatActivity = activity

    @Provides
    fun provideLifecycle(activity: AppCompatActivity): Lifecycle = activity.lifecycle

    @Provides
    fun provideFragmentManager(activity: AppCompatActivity): FragmentManager = activity.supportFragmentManager
}