package dev.kord.rest.builder.interaction

import dev.kord.common.annotation.KordDsl
import dev.kord.common.entity.ApplicationCommandType
import dev.kord.common.entity.ApplicationIntegrationType
import dev.kord.common.entity.InteractionContextType
import dev.kord.common.entity.Permissions
import dev.kord.rest.builder.RequestBuilder
import dev.kord.rest.json.request.ApplicationCommandCreateRequest
import dev.kord.rest.json.request.ApplicationCommandModifyRequest

@KordDsl
public interface ApplicationCommandCreateBuilder : LocalizedNameCreateBuilder,
    RequestBuilder<ApplicationCommandCreateRequest> {

    public var defaultMemberPermissions: Permissions?

    @Deprecated("'defaultPermission' is deprecated in favor of 'defaultMemberPermissions' and 'dmPermission'. Setting 'defaultPermission' to false can be replaced by setting 'defaultMemberPermissions' to empty Permissions and 'dmPermission' to false ('dmPermission' is only available for global commands).")
    public var defaultPermission: Boolean?
    public var integrationTypes: MutableList<ApplicationIntegrationType>?
    public var contexts: MutableList<InteractionContextType>?
    public val type: ApplicationCommandType

    /**
     * Disables the command for everyone except admins by default.
     *
     * **This does not ensure normal users cannot execute the command, any admin can change this setting.**
     */
    public fun disableCommandInGuilds() {
        defaultMemberPermissions = Permissions()
    }

    /**
     * Requires this command to be executed in a specific [installation context][ApplicationIntegrationType].
     */
    public fun requireIntegrationTypes(vararg types: ApplicationIntegrationType) {
        integrationTypes?.addAll(types) ?: run { integrationTypes = types.toMutableList() }
    }

    /**
     * Requires this command to be executed in a specific [interaction context][InteractionContextType].
     */
    public fun requireContext(vararg types: InteractionContextType) {
        contexts?.addAll(types) ?: run { contexts = types.toMutableList() }
    }

    /** Indicates whether the command is age-restricted. Defaults to `false`. */
    public var nsfw: Boolean?
}

@KordDsl
public interface GlobalApplicationCommandCreateBuilder : ApplicationCommandCreateBuilder {
    @Deprecated("Deprecated in favor of contexts", ReplaceWith("requireContext(InteractionContextType.Guild)"))
    public var dmPermission: Boolean?
}

@KordDsl
public interface GlobalApplicationCommandModifyBuilder : ApplicationCommandModifyBuilder {
    @Deprecated("Deprecated in favor of contexts", ReplaceWith("requireContext(InteractionContextType.Guild)"))
    public var dmPermission: Boolean?
}

@KordDsl
public interface ApplicationCommandModifyBuilder : LocalizedNameModifyBuilder,
    RequestBuilder<ApplicationCommandModifyRequest> {

    public var defaultMemberPermissions: Permissions?

    @Deprecated("'defaultPermission' is deprecated in favor of 'defaultMemberPermissions' and 'dmPermission'. Setting 'defaultPermission' to false can be replaced by setting 'defaultMemberPermissions' to empty Permissions and 'dmPermission' to false ('dmPermission' is only available for global commands).")
    public var defaultPermission: Boolean?

    /** Indicates whether the command is age-restricted. */
    public var nsfw: Boolean?
}
