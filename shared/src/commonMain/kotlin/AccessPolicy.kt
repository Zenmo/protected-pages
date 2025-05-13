package energy.lux.protectedpages.shared

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@OptIn(ExperimentalJsExport::class)
@JsExport
@Serializable
sealed class AccessPolicy {
    class Public : AccessPolicy()

    class RoleBased(
        val requiredRole: String,
    ) : AccessPolicy()

    companion object {
    }
}
