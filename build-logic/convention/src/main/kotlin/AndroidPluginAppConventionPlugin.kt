/*
 * SPDX-License-Identifier: LGPL-2.1-or-later
 * SPDX-FileCopyrightText: Copyright 2021-2023 Fcitx5 for Android Contributors
 */
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.configurationcache.extensions.capitalized
import org.gradle.kotlin.dsl.configure

/**
 * Register `assemble${Variant}Plugins` task for root project,
 * and make all plugins' `assemble${Variant}` depends on it
 */
class AndroidPluginAppConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.extensions.configure<BaseAppModuleExtension> {
            buildTypes {
                release {
                    buildConfigField("String", "MAIN_APPLICATION_ID", "\"com.baidu.input_mi\"")
                    addManifestPlaceholders(
                        mapOf(
                            "mainApplicationId" to "com.baidu.input_mi",
                        )
                    )
                }
                debug {
                    buildConfigField("String", "MAIN_APPLICATION_ID", "\"com.baidu.input_mi.debug\"")
                    addManifestPlaceholders(
                        mapOf(
                            "mainApplicationId" to "com.baidu.input_mi.debug",
                        )
                    )
                }
            }
            applicationVariants.all {
                val pluginsTaskName = "assemble${name.capitalized()}Plugins"
                val pluginsTask = target.rootProject.tasks.findByName(pluginsTaskName)
                    ?: target.rootProject.task(pluginsTaskName)
                pluginsTask.dependsOn(assembleProvider)
            }
        }
    }

}
