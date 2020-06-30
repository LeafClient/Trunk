package com.leafclient.trunk.manager

import com.leafclient.trunk.structure.Labelable

/**
 * A [Manager] implementation that relies on the [Labelable] interface specific yet
 * useful methods.
 */
@Suppress("unchecked_cast")
open class LabelableManager(vararg labelables: Labelable): Manager<String, Labelable> {

    private val values = mutableMapOf<String, Labelable>()

    init {
        values += labelables.associateBy { it.label }
    }

    override fun <T : Labelable> get(key: String): T? {
        return values[key] as T?
    }

    override fun set(key: String, value: Labelable) {
        values[key] = value
    }

    open fun add(labelable: Labelable) {
        values[labelable.label] = labelable
    }

    open fun addAll(vararg labelable: Labelable)
            = values.putAll(labelable.associateBy { it.label })

    open fun addAll(collection: Collection<Labelable>)
            = values.putAll(collection.associateBy { it.label })

}