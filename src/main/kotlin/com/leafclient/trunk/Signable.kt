package com.leafclient.trunk

/**
 * As a closed source yet collaborative project, some part of Leaf will be written
 * by different people. [Signable] allows us to hold author's name inside of a class.
 */
interface Signable {

    val authors: Array<out String>

}

/**
 * A data class used to hold information about an [Author]
 */
data class Author(
        val name: String,
        val description: String = "?",
        val discord: String = "?",
        val gitLink: String = "https://github.com/$name"
)

object AuthorRegistry {
    private val registry = mutableMapOf<String, Author>()

    /**
     * Registers each [authors] inside of the registry.
     */
    fun with(vararg authors: Author)
            = registry.putAll(authors.associateBy(Author::name))

    /**
     * Returns the [Author] instance from the [registry] if it exists
     * otherwise returns an empty [Author] with [name].
     */
    operator fun get(name: String)
             = registry[name] ?: Author(name)
}

/**
 * Parses the authors names contained inside of [Signable.authors] into
 * their [Author] instance contained in the [AuthorRegistry] registry.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Signable.parseAuthors()
        = authors.map(AuthorRegistry::get)
