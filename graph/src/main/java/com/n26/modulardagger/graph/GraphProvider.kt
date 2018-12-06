package com.n26.modulardagger.graph

import com.n26.modulardagger.graph.RetentionPolicy.NO_POLICY
import kotlin.reflect.KClass

abstract class GraphProvider<T : Graph> {

    fun provideGraph(): T {
        val component = getFromStoreOrCreateGraph()
        getGraphStore()?.storeGraph(component)

        return component
    }

    private fun getGraphStore(): GraphStore? =
        retentionPolicy()
            .takeUnless { it == NO_POLICY }
            ?.let { GraphStoreProvider.getGraphStore(it) }

    @Suppress("UNCHECKED_CAST")
    private fun getFromStoreOrCreateGraph(): T =
        (getGraphStore()?.getGraph(graphClass()) ?: createGraph()) as T

    protected abstract fun retentionPolicy(): RetentionPolicy

    protected abstract fun createGraph(): Graph

    protected abstract fun graphClass(): KClass<T>
}
