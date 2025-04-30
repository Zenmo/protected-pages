package energy.lux.protectedpages.shared

import kotlinx.serialization.Serializable

@Serializable
sealed class AccessPolicy {
    class Public : AccessPolicy()

    class RoleBased(
        val requiredRole: String,
    ) : AccessPolicy()
}
