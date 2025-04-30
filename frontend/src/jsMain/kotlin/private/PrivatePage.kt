package energy.lux.protectedpages.frontend.private

import energy.lux.protectedpages.shared.AccessPolicy
import kotlinx.browser.window
import org.w3c.dom.HTMLDivElement

/** this JS file can only be downloaded by authorized users */
@JsExport
val accessPolicy = AccessPolicy.RoleBased("admin")

@JsExport
fun privatePage() {
    (window.document.getElementById("content") as HTMLDivElement).innerText = "This is very secret!"
}
