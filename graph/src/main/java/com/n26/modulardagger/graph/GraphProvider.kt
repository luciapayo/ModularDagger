package com.n26.modulardagger.graph

import kotlin.reflect.KClass

abstract class GraphProvider<T : Graph> {

    fun provideGraph(): T {
        val component = GraphStore.getGraph(graphClass())
            ?: createGraph()

        when (scopePolicy()) {
            ScopePolicy.APP -> GraphStore.storeGraph(component)
        }

        return component as T
    }

    protected abstract fun scopePolicy(): ScopePolicy

    protected abstract fun createGraph(): T

    protected abstract fun graphClass(): KClass<T>
}

enum class ScopePolicy {
    APP, USER_SESSION, NO_POLICY
}