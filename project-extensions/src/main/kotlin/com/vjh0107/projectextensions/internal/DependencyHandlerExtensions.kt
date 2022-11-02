package com.vjh0107.projectextensions.internal

import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import com.vjh0107.projectextensions.internal.support.uncheckedCast

fun DependencyHandler.project(path: String, configuration: String? = null): ProjectDependency {
    val projectMap = if (configuration != null) {
        mapOf("path" to path, "configuration" to configuration)
    } else {
        mapOf("path" to path)
    }
    return uncheckedCast(project(projectMap))
}