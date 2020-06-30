package com.leafclient.trunk.setting

import fr.shyrogan.konfigurate.callback.SettingCallback
import fr.shyrogan.konfigurate.setting.SettingBuilder

/**
 * The [SettingCallback] implementation used by trunk
 */
object TrunkSettingCallback: SettingCallback {

    @Suppress("unchecked_cast")
    override fun <T : Any> onCreate(setting: SettingBuilder<T>) {
        if(setting.defaultValue is Boolean) {
            setting as SettingBuilder<Boolean>
            setting.toggleable(setting.defaultValue)
        }
    }

}