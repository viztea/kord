package com.gitlab.hopebaron.websocket.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Emoji(
        val id: String? = null,
        val name: String,
        val roles: List<String>? = null,
        val user: User? = null,
        @SerialName("require_colons")
        val requireColons: Boolean? = null,
        val managed: Boolean? = null,
        val animated: Boolean? = null
)

@Serializable
data class UpdatedEmojis(
        @SerialName("guild_id")
        val guildId: String,
        val emojis: List<Emoji>
)
