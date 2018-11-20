package com.n26.modulardagger.presentation_1

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface Presentation1ActivityComponent : AndroidInjector<Presentation1Activity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<Presentation1Activity>()
}