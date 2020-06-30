package com.leafclient.trunk.structure

/**
 * Marks a [Labelable] class using the [label] property.
 */
interface Labelable {

    /**
     * Returns the label of this labelable class
     */
    val label: String

}

/**
 * Searches for a [label] if this object can be labeled otherwise returns
 * the class name.
 */
val Any.label: String?
    get() = if(this is Labelable) this.label else null