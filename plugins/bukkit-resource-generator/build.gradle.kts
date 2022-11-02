plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish")
    id("com.github.johnrengelman.shadow")
}

tasks.shadowJar {
    archiveClassifier.set("")
}

dependencies {
    implementation("com.github.BarcodeNetwork.BarcodeGradlePlugins:buildscripts-common:1.1.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3") {
        exclude(group = "org.jetbrains.kotlin")
    }
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.3")
}

version = "1.0.1"
group = "com.vjh0107"

gradlePlugin {
    plugins {
        register("bukkit-resource-generator") {
            displayName = "BukkitResourceGenerator"
            description = "Bukkit resource auto generator plugin"
            id = "com.vjh0107.bukkit-resource-generator"
            implementationClass = "com.vjh0107.barcode.buildscripts.resourcegenerator.BukkitResourceGeneratorPlugin"
        }
    }
}

pluginBundle {
    val projectUrl: String by project
    website = projectUrl
    vcsUrl = projectUrl
    description = project.description
    tags = listOf("barcode", "bukkit-resource-generator")
}