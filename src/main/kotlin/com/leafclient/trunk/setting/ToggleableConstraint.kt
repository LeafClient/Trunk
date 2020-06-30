package com.leafclient.trunk.setting
import com.leafclient.trunk.structure.Toggleable
import fr.shyrogan.konfigurate.setting.SettingBuilder
import fr.shyrogan.konfigurate.setting.constraint.Constraint

/**
 * Implements the [Toggleable] interface for a [Boolean] typed setting.
 */
class ToggleableConstraint(
        override var isRunning: Boolean
): Constraint<Boolean>, Toggleable {

    override fun invoke(current: Boolean, future: Boolean) = future.also {
        isRunning = future
    }

}

fun SettingBuilder<Boolean>.toggleable(defaultState: Boolean) {
    constraints += ToggleableConstraint(defaultState)
}