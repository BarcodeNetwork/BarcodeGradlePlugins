import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish")
    id("com.github.johnrengelman.shadow")
}

tasks.shadowJar {
    archiveClassifier.set("")
}

val properties = loadProperties(rootProject.projectDir.path + "/gradle.properties")
val kotlinVersion = properties.getProperty("kotlinVersion")
val kspVersion = properties.getProperty("kspVersion")

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:$kspVersion")
    implementation("com.github.BarcodeNetwork.BarcodeGradlePlugins:buildscripts-common:1.1.0")
}

version = "1.0.2"
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

