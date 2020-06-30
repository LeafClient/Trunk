package com.leafclient.trunk.manager

import com.leafclient.trunk.structure.Labelable

/**
 * A [Manager] implementation that associates a class to its instance
 */
@Suppress("unchecked_cast")
open class ClassToInstanceManager<K: Any>(vararg baseValues: K): Manager<Class<K>, K> {

    private val values = mutableMapOf<Class<K>, K>()

    init {
        values.putAll(baseValues.associateBy { it.javaClass })
    }

    override fun <T : K> get(key: Class<K>): T? {
        return values[key] as T?
    }

    override fun set(key: Class<K>, value: K) {
        values[key] = value
    }

    open fun add(value: K) {
        values[value.javaClass] = value
    }

    open fun addAll(vararg addedValues: K)
            = values.putAll(addedValues.associateBy { it.javaClass })

    open fun addAll(collection: Collection<K>)
            = values.putAll(collection.associateBy { it.javaClass })

}