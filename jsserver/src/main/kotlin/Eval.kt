package energy.lux.protectedpages.app

import energy.lux.protectedpages.shared.AccessPolicy
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.*;
import org.graalvm.polyglot.proxy.*;
import java.io.File
import kotlin.io.path.Path

val jscode = """
    export const myobj = 12
""".trimIndent()

val context = Context.newBuilder("js").option("js.esm-eval-returns-exports", "true").build()

/**
 * Take a javascript file and evaluate the exported member accessPolicy
 */
fun eval(file: File): AccessPolicy {
    println("Evaluating $file")

    val source = Source.newBuilder("js", file).build()
//    val source = Source.newBuilder("js", jscode, "test.mjs").build()
    val output = context.eval(source)
    val result = output.getMember("modules")
    println("Script accessPolicy: $result")

    return AccessPolicy.Public()
}
