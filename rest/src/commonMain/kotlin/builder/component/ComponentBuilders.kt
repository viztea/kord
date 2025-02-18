@file:Suppress("PropertyName")

package dev.kord.rest.builder.component

import dev.kord.common.annotation.KordDsl
import dev.kord.common.entity.DiscordComponent
import dev.kord.common.entity.optional.OptionalBoolean
import dev.kord.common.entity.optional.delegate.delegate

@KordDsl
public sealed interface ComponentBuilder {
    public fun build(): DiscordComponent
}

@KordDsl
public sealed class ActionRowComponentBuilder : ContainerComponentBuilder {

    protected var _disabled: OptionalBoolean = OptionalBoolean.Missing
        private set

    /** Whether the component is disabled. Defaults to `false`. */
    public var disabled: Boolean? by ::_disabled.delegate()
}

@KordDsl
public sealed interface MessageComponentBuilder : ComponentBuilder

/**
 * A component that is a child of a container component.
 */
@KordDsl
public sealed interface ContainerComponentBuilder : MessageComponentBuilder

/**
 * A component that is an accessory to a section component.
 */
@KordDsl
public sealed interface AccessoryComponentBuilder : ComponentBuilder
