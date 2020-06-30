package com.leafclient.trunk.file

import java.lang.StringBuilder

/**
 * Represents a section inside of a file.
 */
data class Section(val label: String, val text: String) {

    companion object {
        /**
         * Returns a list of [Section] instances contained by this String
         * (if there are any)
         */
        inline fun String.forEachSection(crossinline lambda: (Section) -> Unit) {
            var currentSectionName = ""
            val builder = StringBuilder()
            this.lines().forEach { line ->
                if(line.isSectionTitle) {
                    if(currentSectionName.isNotEmpty() && builder.isNotEmpty()) {
                        lambda(Section(currentSectionName, builder.toString()))
                        builder.clear()
                    }
                    currentSectionName = line.removePrefix("[").removeSuffix("]")
                } else {
                    if(currentSectionName.isNotEmpty())
                        builder.append(line).append('\n')
                }
            }
            if(currentSectionName.isNotEmpty() && builder.isNotEmpty()) {
                lambda(Section(currentSectionName, builder.toString()))
            }
        }

        /**
         * Writes the section with name [name] containing [text]
         */
        fun WritableFile.writeSection(name: String, text: String) {
            write("[$name]")
            write(text)
        }

        /**
         * Private method used to check whether a line seems to be a section title.
         */
        val String.isSectionTitle: Boolean
            get() = startsWith("[") && endsWith("]")
    }

}