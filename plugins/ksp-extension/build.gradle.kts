import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish")
    id("com.github.johnrengelman.shadow")
}

tasks.shadowJar {
    archiveClassifier.set("")
}

val kotlinVersion = loadProperties(rootProject.projectDir.path + "/gradle.properties").getProperty("kotlinVersion")

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("com.github.BarcodeNetwork.BarcodeGradlePlugins:buildscripts-common:1.1.0")
}

version = "1.0.1"
group = "com.vjh0107"

gradlePlugin {
    plugins {
        register("ksp-extension") {
            displayName = "KSPExtension"
            description = "KSP extension plugin"
            id = "com.vjh0107.ksp-extension"
            implementationClass = "com.vjh0107.barcode.buildscripts.kspextension.KSPExtensionPlugin"
        }
    }
}

pluginBundle {
    val projectUrl: String by project
    website = projectUrl
    vcsUrl = projectUrl
    description = project.description
    tags = listOf("barcode", "ksp-extension")
}

