package com.n26.modulardagger.graph

interface Graph {

    interface Builder {
        fun build(): Graph
    }
}

