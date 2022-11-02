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
    plugins {
        id("com.github.johnrengelman.shadow") version "7.1.2" apply false
    }
    repositories {
        gradlePluginPortal()
    }
}