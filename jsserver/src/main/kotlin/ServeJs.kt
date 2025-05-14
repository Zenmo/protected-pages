package energy.lux.protectedpages.app

import energy.lux.protectedpages.shared.AccessPolicy
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Source
import org.graalvm.polyglot.io.IOAccess
import org.http4k.core.Response
import org.http4k.core.Status
import java.net.URL

fun serveJsResource(resource: URL): Response {
    val accessPolicy = getScriptAccessPolicy(resource)
    println("$resource accessPolicy: $accessPolicy")
    
    return Response(Status.OK)
        .header("Content-Type", "text/javascript")
        .body(resource.openStream())
}

fun getScriptAccessPolicy(resource: URL): AccessPolicy {
    val context = Context.newBuilder("js")
        .option("js.esm-eval-returns-exports", "true")
        .allowIO(IOAccess.ALL) // allow imports
        .build()

    val source = Source.newBuilder("js", resource).build()
    val output = context.eval(source)
    val jsAccessPolicy = output.getMember("accessPolicy")
    val jsonAccessPolicy = jsAccessPolicy.invokeMember("get").invokeMember("toJson")

    println("JSON accessPolicy: $jsonAccessPolicy")

    return AccessPolicy.fromJson(jsonAccessPolicy.asString())
}
