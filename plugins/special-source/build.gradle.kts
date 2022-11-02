plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish")
    id("com.github.johnrengelman.shadow")
}

tasks.shadowJar {
    archiveClassifier.set("")
}

dependencies {
    implementation("net.md-5:SpecialSource:1.11.0")
    implementation("com.github.BarcodeNetwork.BarcodeGradlePlugins:buildscripts-common:1.1.0")
}

version = "1.0.1"
group = "com.vjh0107"

gradlePlugin {
    plugins.register("special-source") {
        displayName = "SpecialSource"
        description = "Spigot SpecialSource gradle plugin"
        id = "com.vjh0107.special-source"
        implementationClass = "com.vjh0107.barcode.buildscripts.specialsource.SpecialSourcePlugin"
    }
}

pluginBundle {
    val projectUrl: String by project
    website = projectUrl
    vcsUrl = projectUrl
    description = project.description
    tags = listOf("barcode", "special-source")
}
