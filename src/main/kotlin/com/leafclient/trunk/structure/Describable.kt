package com.leafclient.trunk.structure

/**
 * Marks a class that can be described using the [description] property.
 */
interface Describable {

    /**
     * Returns the description of this Describable class
     */
    val description: String
        get() = NO_DESCRIPTION_SET

    companion object {
        const val NO_DESCRIPTION_SET = "No description set."
    }

}

/**
 * Searches for a [label] if this object can be labeled otherwise returns
 * null.
 */
val Any.description: String
    get() = if(this is Describable) this.description else Describable.NO_DESCRIPTION_SET