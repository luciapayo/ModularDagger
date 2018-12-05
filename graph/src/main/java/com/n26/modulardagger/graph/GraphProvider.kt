package com.n26.modulardagger.graph

import kotlin.reflect.KClass

abstract class GraphProvider<T : Graph> {

    fun provideGraph(): T {
        val component = getFromStoreOrCreateGraph()

        when (scopePolicy()) {
            ScopePolicy.APP -> GraphStore.storeGraph(component)
        }

        return component
    }

    private fun getFromStoreOrCreateGraph(): T =
        (GraphStore.getGraph(graphClass()) ?: createGraph()) as T

    protected abstract fun scopePolicy(): ScopePolicy

    protected abstract fun createGraph(): Graph

    protected abstract fun graphClass(): KClass<T>
}

enum class ScopePolicy {
    APP, USER_SESSION, NO_POLICY
}