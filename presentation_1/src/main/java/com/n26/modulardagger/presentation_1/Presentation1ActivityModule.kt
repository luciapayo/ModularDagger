package com.n26.modulardagger.presentation_1

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class Presentation1ActivityModule {

//    @Binds
//    @IntoMap
//    @ClassKey(Presentation1Activity::class)
//    abstract fun bindPresentation1ActivityInjectorFactory(builder: Presentation1ActivityComponent.Builder): AndroidInjector.Factory<out Activity>

    @ContributesAndroidInjector
    abstract fun presentation1Activity(): Presentation1Activity
}
