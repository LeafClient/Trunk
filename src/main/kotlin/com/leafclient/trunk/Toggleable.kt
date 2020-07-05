package com.leafclient.trunk

/**
 * As a "addon" to the game, Leaf will provide toggleable features and [Toggleable]
 * is used to recognize them.
 */
interface Toggleable {

    /**
     * Returns whether this [Toggleable] object is running or not and
     * allows modifying its state.
     */
    var isRunning: Boolean

    /**
     * Modifies the [isRunning] value of its opposite.
     */
    fun toggle() {
        isRunning = !isRunning
    }

}