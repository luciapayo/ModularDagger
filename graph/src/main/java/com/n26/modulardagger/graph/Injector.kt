package com.n26.modulardagger.graph

interface Injector<T> {

    fun inject(t: T)

    interface Builder<T> {

        fun build(): Injector<T>
    }
}
