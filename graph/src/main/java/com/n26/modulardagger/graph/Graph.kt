package com.n26.modulardagger.graph

class Graph {

    fun <T> createComponent(builder: Injector.Builder<T>): Injector<T> =
        builder.build()
}