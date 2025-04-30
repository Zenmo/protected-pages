package energy.lux.protectedpages.frontend

import kotlinx.browser.window
import energy.lux.protectedpages.shared.AccessPolicy
import js.import.importAsync
import org.w3c.dom.HTMLDivElement

/** this JS file can be loaded by anyone */
@JsExport
val accessPolicy = AccessPolicy.Public()

@JsExport
fun main() {
    render()
}

@JsExport
fun dispatch(path: String) {
    window.history.pushState("", "", path)
    render()
}

external interface PrivatePageModule {
    fun privatePage(): Unit
}

fun render() {
    val path = window.location.pathname

    console.log("rendering $path")

    when {
        path.matches(Regex("^/private.*")) ->
            importAsync<PrivatePageModule>("./private/PrivatePage.export.mjs")
                .then { it.privatePage() }
        path.matches(Regex("^/public.*")) -> publicPage()
        else -> (window.document.getElementById("content") as HTMLDivElement).innerText = "Page not found."
    }
}
