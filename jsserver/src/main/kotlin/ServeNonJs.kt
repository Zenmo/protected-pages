package energy.lux.protectedpages.app

import org.http4k.core.Response
import org.http4k.core.Status
import java.net.URL

fun serveNonJsResource(resource: URL): Response {
    return try {
        val inputStream = resource.openStream()

        val content = inputStream.readBytes()
        inputStream.close()
        Response.Companion(Status.Companion.OK).body(String(content))
    } catch (e: Exception) {
        Response.Companion(Status.Companion.INTERNAL_SERVER_ERROR).body("Error reading $resource: $e")
    }
}
