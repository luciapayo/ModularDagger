package com.n26.modulardagger.graph

import java.util.*

class GraphProvider {

    private val graphMap: HashMap<Class<out Graph>, Graph> = HashMap()

    fun createGraph(graphCreator: GraphCreator): Graph = graphCreator.create()
}
