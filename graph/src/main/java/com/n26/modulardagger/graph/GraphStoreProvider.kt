package com.n26.modulardagger.graph

import android.util.Log
import com.n26.modulardagger.graph.RetentionPolicy.NO_POLICY

// TODO: Assert Main Thread
object GraphStoreProvider {

    private val storeMap: HashMap<RetentionPolicy, GraphStore> = HashMap()

    internal fun getGraphStore(retentionPolicy: RetentionPolicy): GraphStore {
        if (retentionPolicy == NO_POLICY) {
            throw IllegalArgumentException("$retentionPolicy means graphs are not stored here!")
        }

        return storeMap.getOrPut(retentionPolicy) { GraphStore() }
    }

    fun clearGraphStore(retentionPolicy: RetentionPolicy) {
        storeMap[retentionPolicy]?.clear() ?: Log.d(
            "GraphStoreProvider",
            "No graph store for retention policy $retentionPolicy"
        )
    }
}
