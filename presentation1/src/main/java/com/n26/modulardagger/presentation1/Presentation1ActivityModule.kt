package com.n26.modulardagger.presentation1

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [Presentation1ActivityComponent::class])
abstract class Presentation1ActivityModule {

//    @Binds
//    @IntoMap
//    @ClassKey(Presentation1Activity::class)
//    abstract fun bindPresentation1ActivityInjectorFactory(builder: Presentation1ActivityComponent.Builder): AndroidInjector.Factory<out Activity>

    @ContributesAndroidInjector
    abstract fun presentation1Activity(): Presentation1Activity
}