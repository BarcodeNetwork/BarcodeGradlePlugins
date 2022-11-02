rootProject.name = "BarcodeGradlePlugins"

val modulesDir = "plugins"

if (System.getenv("JITPACK") == "true") {
    include("plugins:common")
} else {
    file("${rootProject.projectDir.path}/${modulesDir.replace(":", "/")}/").listFiles()?.forEach { modulePath ->
        include("${modulesDir.replace("/", ":")}:${modulePath.name}")
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    plugins {
        id("com.gradle.plugin-publish") version "1.0.0"
    }
}