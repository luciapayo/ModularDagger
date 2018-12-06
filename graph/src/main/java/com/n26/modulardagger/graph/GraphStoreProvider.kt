package com.n26.modulardagger.graph

import com.n26.modulardagger.graph.RetentionPolicy.NO_POLICY

// TODO: Assert Main Thread
internal object GraphStoreProvider {

    private val storeMap: HashMap<RetentionPolicy, GraphStore> = HashMap()

    fun getGraphStore(retentionPolicy: RetentionPolicy): GraphStore {
        if (retentionPolicy == NO_POLICY) {
            throw IllegalArgumentException("$retentionPolicy means graphs are not stored here!")
        }

        return storeMap.getOrPut(retentionPolicy) { GraphStore() }
    }
}
