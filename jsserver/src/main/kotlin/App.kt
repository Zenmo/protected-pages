package energy.lux.protectedpages.app

import java.io.StringWriter
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.*;
import org.graalvm.polyglot.proxy.*;
import kotlin.io.path.Path

val jscode = """
    export const myobj = 12
""".trimIndent()


fun main() {
    println("Current working directory: ${Path(".").toAbsolutePath()}")

    val context = Context.newBuilder("js").option("js.esm-eval-returns-exports", "true").build()
    val source = Source.newBuilder("js", jscode, "test.mjs").build()
    val output = context.eval(source)
    val result = output.getMember("myobj")
    println("Script output: $result")
}
