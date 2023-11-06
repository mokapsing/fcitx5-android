package org.fcitx.fcitx5.android.core.data

import org.fcitx.fcitx5.android.core.data.PluginDescriptor.Companion.pluginPackagePrefix
import org.fcitx.fcitx5.android.utils.Const

/**
 * Metadata of a plugin, at `res/xml/plugin.xml`
 */
data class PluginDescriptor(
    /**
     * Must have [pluginPackagePrefix] prefix and end with `.debug` if it's debug variant
     */
    val packageName: String,
    /**
     * For future incompatible updates
     */
    val apiVersion: String,
    /**
     * May provide gettext domain
     */
    val domain: String?,
    /**
     * Can use string resource, e.g. `@string/description`
     */
    val description: String,
    /**
     * Contains IPC service with action `${mainApplicationId}.plugin.SERVICE`. Default to `false`.
     */
    val hasService: Boolean,
    val versionName: String,
    val nativeLibraryDir: String,
    val libraryDependency: Map<String, List<String>>
) {
    val name by lazy {
        packageName.removePrefix("$pluginPackagePrefix.").removeSuffix(".${Const.buildType}")
    }

    companion object {
        const val pluginPackagePrefix = "org.fcitx.fcitx5.android.plugin"
        const val pluginAPI = "0.1"
    }
}