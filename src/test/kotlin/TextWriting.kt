import com.leafclient.trunk.file.Section.Companion.forEachSection
import com.leafclient.trunk.file.Section.Companion.writeSection
import com.leafclient.trunk.file.WritableFile
import com.leafclient.trunk.utility.Delayer
import fr.shyrogan.konfigurate.Group
import fr.shyrogan.konfigurate.serialization.GroupSerializer.serialize
import java.nio.file.Paths

fun main() {
    TextWriting.onWrite()
    TextWriting.onRead()
}

object TextWriting: WritableFile(Paths.get("hi")) {

    private val groups = listOf(
            First(), Second()
    )

    override fun onWrite() {
        groups.forEach {
            writeSection(it.name, it.serialize())
        }
        println(this)
    }

    override fun onRead() {
        builder.toString().forEachSection {
            println(it.label)
            println(it.text)
        }
    }

    class First: Group("First Hey!") {
        val idk by setting("Idk", false)
    }

    class Second: Group("Second hey!") {
        val hi by setting("Hi!", Delayer())
    }

}