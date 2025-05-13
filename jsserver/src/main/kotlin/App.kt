package energy.lux.protectedpages.app

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.core.Status.Companion.OK
import org.http4k.server.Undertow
import org.http4k.server.asServer
import java.io.File


fun main() {
    eval(File("./frontend/build/dist/js/productionExecutable/317.mjs"))
}

fun startServer() {
    val app = serveJsFiles("./frontend/build/dist/js/productionExecutable")

    val server = app.asServer(Undertow(9000)).start()

    server.stop()
}

fun serveJsFiles(rootPath: String = "."): HttpHandler {
    return { request: Request ->
        val path = request.uri.path

        if (!path.endsWith(".mjs") && !path.endsWith(".js")) {
            Response(BAD_REQUEST).body("Only serving JavaScript files")
        }

        val file = File("$rootPath/$path")
        if (!file.exists()) {
            Response(NOT_FOUND).body("File not found")
        }

        Response(OK).body("Hello, $path!")
    }
}
