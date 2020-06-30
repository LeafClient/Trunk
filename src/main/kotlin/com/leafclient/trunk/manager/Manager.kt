package com.leafclient.trunk.manager

/**
 * Represents a [Manager] in the client.
 */
interface Manager<KEY: Any, VALUE: Any> {

    /**
     * Returns a [VALUE] from a [KEY]
     */
    operator fun <T: VALUE> get(key: KEY): T?

    /**
     * Defines the value to [value] to [key]
     */
    operator fun set(key: KEY, value: VALUE)

}