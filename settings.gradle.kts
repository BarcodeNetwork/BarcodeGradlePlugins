rootProject.name = "BarcodeGradlePlugins"

fun includeAll(modulesDir: String) {
    file("${rootProject.projectDir.path}/${modulesDir.replace(":", "/")}/").listFiles()?.forEach { modulePath ->
        include("${modulesDir.replace("/", ":")}:${modulePath.name}")
    }
}

include("project-extensions")
include("plugin-common")

if (System.getenv("JITPACK") != "true") {
    includeAll("plugins")
}

pluginManagement {
    plugins {
        id("com.github.johnrengelman.shadow") version "7.1.2" apply false
    }
    repositories {
        gradlePluginPortal()
    }
}