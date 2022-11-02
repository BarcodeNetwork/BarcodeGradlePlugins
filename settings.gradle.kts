rootProject.name = "BarcodeGradlePlugins"

val modulesDir = "plugins"

file("${rootProject.projectDir.path}/${modulesDir.replace(":", "/")}/").listFiles()?.forEach { modulePath ->
    include("${modulesDir.replace("/", ":")}:${modulePath.name}")
}
