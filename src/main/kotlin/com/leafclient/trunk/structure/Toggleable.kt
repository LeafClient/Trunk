package com.leafclient.trunk.structure

/**
 * Marks a [Toggleable] class using the [isRunning] property.
 */
interface Toggleable {

    /**
     * Returns whether this object is running or not and modifies its state
     * if we want.
     */
    var isRunning: Boolean

    /**
     * Defines the [isRunning] state to it's opposite.
     */
    fun toggle() {
        this.isRunning = !this.isRunning
    }

}