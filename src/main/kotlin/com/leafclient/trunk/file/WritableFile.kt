package com.leafclient.trunk.file

import java.lang.StringBuilder
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path

abstract class WritableFile(val PATH: Path) {

    val builder = StringBuilder()

    /**
     * Method invoked when we want to write this [WritableFile].
     */
    abstract fun onWrite()

    /**
     * Method invoked when we want to write this [WritableFile].
     */
    abstract fun onRead()

    /**
     * Writes to the current [builder] specified [text] and a new line
     * character if [newLine] is true.
     */
    fun write(text: String, newLine: Boolean = true) {
        builder.append(text)
        if(newLine)
            builder.append('\n')
    }

    /**
     * Pushes the current [builder] into the file with path [PATH].
     * This method will not throw any error if the file doesn't exist, it will
     * automatically create all the subdirectories required and the file.
     */
    fun push(charset: Charset = Charsets.UTF_8) {
        PATH.createIfNotExists()
        PATH.writeText(builder.toString(), charset)
        builder.clear()
    }

    /**
     * @inheritDoc
     */
    override fun toString(): String {
        return "WritableFile(PATH=$PATH, text=$builder)"
    }


    companion object {
        /**
         * Creates the file for this path by creating all the parent directories first.
         */
        fun Path.createIfNotExists() {
            Files.createDirectories(this)
            Files.createFile(this)
        }

        /**
         * Reads the text contained by the file using [charset] at this
         * path (if it exists).
         */
        fun Path.readText(charset: Charset = Charsets.UTF_8): String
                = Files.readAllBytes(this).toString(charset)

        /**
         * Writes [text] into the file at this path using [charset]
         */
        fun Path.writeText(text: String, charset: Charset = Charsets.UTF_8)
                = Files.write(this, text.toByteArray(charset))
    }

}