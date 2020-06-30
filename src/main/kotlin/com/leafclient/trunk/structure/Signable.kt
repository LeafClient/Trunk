package com.leafclient.trunk.structure

/**
 * Contains various information about the [Author] of stuff inside of the client.
 */
data class Author(
    val nickname: String,
    val description: String
)

/**
 * Marks a [Signable] class using the [authors] property
 */
interface Signable {

    /**
     * Returns the authors of this class
     */
    val authors: Array<Author>

}

