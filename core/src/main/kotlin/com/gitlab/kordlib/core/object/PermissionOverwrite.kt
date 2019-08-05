package com.gitlab.kordlib.core.`object`

import com.gitlab.kordlib.common.entity.Overwrite
import com.gitlab.kordlib.common.entity.Permissions
import com.gitlab.kordlib.core.entity.Snowflake
import com.gitlab.kordlib.rest.json.request.EditChannelPermissionRequest

class PermissionOverwrite private constructor(
        val allowed: Permissions,
        val denied: Permissions,
        val target: Snowflake,
        val type: String
) {

    internal fun asRequest() = EditChannelPermissionRequest(allowed, denied, type)

    internal fun toOverwrite() = Overwrite(id = target.value, type = type, allow = allowed.code, deny = denied.code)

    companion object {
        fun forEveryone(guildId: Snowflake, allowed: Permissions = Permissions(), denied: Permissions = Permissions()) =
                PermissionOverwrite(allowed, denied, guildId, "role")

        fun forMember(memberId: Snowflake, allowed: Permissions = Permissions(), denied: Permissions = Permissions()) =
                PermissionOverwrite(allowed, denied, memberId, "member")

        fun forRole(roleId: Snowflake, allowed: Permissions = Permissions(), denied: Permissions = Permissions()) =
                PermissionOverwrite(allowed, denied, roleId, "role")
    }

}