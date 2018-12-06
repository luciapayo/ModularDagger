package com.n26.modulardagger.graph

import java.util.*
import kotlin.reflect.KClass

// TODO: Assert Main Thread in all methods.
internal class GraphStore {

    private val graphMap: HashMap<KClass<out Graph>, Graph> = HashMap()

    fun getGraph(graphClass: KClass<out Graph>): Graph? = graphMap[graphClass]

    fun storeGraph(graph: Graph) {
        graphMap[graph::class] = graph
    }

    fun clear() = graphMap.clear()
}
