package com.n26.modulardagger.graph

interface Graph {

    interface Builder {
        fun build(): Graph
    }
}

interface Injector<T> : Graph {

    fun inject(t: T)

    interface Builder<T> : Graph.Builder {

        override fun build(): Injector<T>
    }
}
