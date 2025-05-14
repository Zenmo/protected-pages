package energy.lux.protectedpages.app

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters
import org.http4k.server.Undertow
import org.http4k.server.asServer


fun main() {
    startServer()
}

fun startServer() {
    val app: HttpHandler = DebuggingFilters.PrintRequest()
        .then { serveFiles(it) }

    val server = app.asServer(Undertow(9000)).start()

//    server.stop()
}

fun serveFiles(request: Request): Response {
    val path = request.uri.path

    val resourceUrl = object {}.javaClass.getResource(path)
    if (resourceUrl == null) {
        return Response(NOT_FOUND).body("No file at $path")
    }

    return if (path.endsWith(".mjs") or path.endsWith(".js")) {
        serveJsResource(resourceUrl)
    } else {
        serveNonJsResource(resourceUrl)
    }
}
