plugins {
    `kotlin-dsl`
    `maven-publish`
}

repositories {
    mavenCentral()
}

group = "com.vjh0107.barcode"
version = "1.1.2"

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.vjh0107.barcode"
            artifactId = "project-extensions"
            version = project.version.toString()

            from(components["java"])
        }
    }
}
