package com.n26.modulardagger.graph

class GraphProvider {

    fun <T> createInjector(builder: Injector.Builder<T>): Injector<T> =
        builder.build()

    fun createGraph(builder: Graph.Builder): Graph =
        builder.build()
}