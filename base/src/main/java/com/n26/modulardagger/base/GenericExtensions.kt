package com.n26.modulardagger.base

inline fun <reified T> T?.isNotNull(): T =
    this ?: throw IllegalStateException("This object must not be null: ${T::class}")