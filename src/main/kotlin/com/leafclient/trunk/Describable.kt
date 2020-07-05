package com.leafclient.trunk

/**
 * Throughout the client, we'll provide descriptions to the user allowing him to understand
 * easily what provided functionalities does.
 * The [Describable] interface contains a [description] and shares the same conditions as [Identifiable]
 * (for the same reasons) yet it provides a default value (see [Descriptions.UNPROVIDED]).
 */
interface Describable {

    /**
     * Returns the description in a String form or
     * [Descriptions.UNPROVIDED] if no descriptions are provided.
     */
    val description: String
        get() = Descriptions.UNPROVIDED

}

object Descriptions {
    /**
     * The description returned if the [Describable] does not provide any
     * description.
     */
    const val UNPROVIDED = "client.unprovided_description"
}

/**
 * Returns "true" if this [Describable] object is not described.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Describable.isNotDescribed()
        = description.equals(Descriptions.UNPROVIDED, true)

/**
 * Returns "true" if this [Describable] object is described.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Describable.isDescribed()
        = !description.equals(Descriptions.UNPROVIDED, true)