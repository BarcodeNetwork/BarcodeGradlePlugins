plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish")
}

dependencies {
    implementation(project(":plugins:common"))
}

version = "1.0.1-beta2"
group = "com.vjh0107"

gradlePlugin {
    plugins {
        register("bukkit-executor") {
            displayName = "BukkitExecutor"
            description = "Bukkit executor plugin"
            id = "com.vjh0107.bukkit-executor"
            implementationClass = "com.vjh0107.barcode.buildscripts.bukkitexecutor.BukkitExecutorPlugin"
        }
    }
}

pluginBundle {
    val projectUrl: String by project
    website = projectUrl
    vcsUrl = projectUrl
    description = project.description
    tags = listOf("barcode", "bukkit-executor")
}

