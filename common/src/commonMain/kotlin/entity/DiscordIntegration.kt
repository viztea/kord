@file:Generate(
    INT_KORD_ENUM, name = "IntegrationExpireBehavior",
    docUrl = "https://discord.com/developers/docs/resources/guild#integration-object-integration-expire-behaviors",
    entries = [
        Entry("RemoveRole", intValue = 0),
        Entry("Kick", intValue = 1),
    ],
)

@file:Generate(
    INT_KORD_ENUM, name = "ApplicationIntegrationType",
    docUrl = "https://discord.com/developers/docs/resources/application#application-object-application-integration-types",
    kDoc = "Where an app can be installed, also called its supported installation contexts",
    entries = [
        Entry("GuildInstall", intValue = 0, kDoc = "App is installable to servers"),
        Entry("UserInstall", intValue = 1, kDoc = "App is installable to users"),
    ],
)

package dev.kord.common.entity

import dev.kord.common.entity.optional.Optional
import dev.kord.common.entity.optional.OptionalBoolean
import dev.kord.common.entity.optional.OptionalInt
import dev.kord.common.entity.optional.OptionalSnowflake
import dev.kord.common.serialization.DurationInDays
import dev.kord.ksp.Generate
import dev.kord.ksp.Generate.EntityType.INT_KORD_ENUM
import dev.kord.ksp.Generate.Entry
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DiscordIntegration(
    val id: Snowflake,
    val name: String,
    val type: String,
    val enabled: Boolean,
    @SerialName("role_id")
    val roleId: OptionalSnowflake = OptionalSnowflake.Missing,
    @SerialName("enable_emoticons")
    val enableEmoticons: OptionalBoolean = OptionalBoolean.Missing,
    @SerialName("expire_behavior")
    val expireBehavior: Optional<IntegrationExpireBehavior> = Optional.Missing(),
    @SerialName("expire_grace_period")
    val expireGracePeriod: Optional<DurationInDays> = Optional.Missing(),
    val user: Optional<DiscordUser> = Optional.Missing(),
    val account: DiscordIntegrationsAccount,
    @SerialName("synced_at")
    val syncedAt: Optional<Instant> = Optional.Missing(),
    @SerialName("subscriber_count")
    val subscriberCount: OptionalInt = OptionalInt.Missing,
    val revoked: OptionalBoolean = OptionalBoolean.Missing,
    val application: Optional<IntegrationApplication> = Optional.Missing(),
    @SerialName("guild_id") // available in Integration Create and Integration Update events
    val guildId: OptionalSnowflake = OptionalSnowflake.Missing,
)

@Serializable
public data class DiscordPartialIntegration(
    val id: Snowflake,
    val name: String,
    val type: String,
    val account: DiscordIntegrationsAccount,
)

@Serializable
public data class IntegrationApplication(
    val id: Snowflake,
    val name: String,
    val icon: String?,
    val description: String,
    val bot: Optional<DiscordUser> = Optional.Missing(),
)

@Serializable
public data class DiscordIntegrationsAccount(
    val id: String,
    val name: String
)
