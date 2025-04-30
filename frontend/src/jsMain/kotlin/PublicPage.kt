package energy.lux.protectedpages.frontend

import kotlinx.browser.window
import org.w3c.dom.HTMLDivElement

fun publicPage() {
    (window.document.getElementById("content") as HTMLDivElement).innerText = "This is a public page. Open to all."
}
