package com.leafclient.trunk

import java.lang.RuntimeException

/**
 * Throughout the client, we'll need to recognize some object instances and we will generally
 * use the [Identifiable] to mark and recognize them.
 * The [identifier] can only consist of characters "a-z", numbers "0-9" and "_", "." and is considered
 * as the translation key inside of the client.
 */
interface Identifiable {

    /**
     * Returns the identifier in a String form.
     * (throws an error if it doesn't match the conditions listed above)
     */
    val identifier: String

}

/**
 * Exception thrown when a [Identifiable] does not match
 */
class InvalidIdentifierException(identifier: String): RuntimeException(
        "$identifier contains invalid characters! (see the Identifiable class in Trunk)"
)

/**
 * A [Regex] used to check whether a String matches the conditions required to
 * be considered as an identifier.
 */
val IDENTIFIER_PATTERN = "^[a-z0-9_.]+$".toRegex()

/**
 * Returns whether [Identifiable] matches the condition required to
 * use the [Identifiable] interface.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Identifiable.isValid() = identifier.matches(IDENTIFIER_PATTERN)

/**
 * Throws a [InvalidIdentifierException] if the identifier does not match the
 * condition to be considered as an [Identifiable].
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Identifiable.checkIfIdentifiable() {
    if(!isValid())
        throw InvalidIdentifierException(identifier)
}